package priv.yq.sparrow.provide;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.yq.sparrow.UserRest;
import priv.yq.sparrow.dto.UserDTO;
import priv.yq.sparrow.entity.User;
import priv.yq.sparrow.result.ErrorCode;
import priv.yq.sparrow.result.Result;
import priv.yq.sparrow.service.UserService;
import priv.yq.sparrow.util.EncryptUtil;

import java.util.UUID;

/**
 * Created by yaoqing on 2018/11/28.
 */
@Component
public class UserProvide implements UserRest {

    private static Logger log = LoggerFactory.getLogger(UserProvide.class);

    @Autowired
    private UserService userService;

    @Override
    public Result register(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.error(ErrorCode.ERROR_0XO0001.getCode(), ErrorCode.ERROR_0XO0001.getMsg());
        }
        if (checkUsernameValid(username)) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            String salt = UUID.randomUUID().toString().replace("-", "");
            try {
                String encryptPwd = EncryptUtil.encryptSHA256(password, salt);
                user.setSalt(salt);
                user.setPassword(encryptPwd);
            } catch (Exception e) {
                log.error("密码加密异常：{}", e);
                return Result.error(ErrorCode.ERROR_0XO0000.getCode(), ErrorCode.ERROR_0XO0000.getMsg());
            }
            user.setNickName(username);
            userService.save(user);
            return Result.success();
        } else {
            return Result.error(ErrorCode.ERROR_0XO0003.getCode(), ErrorCode.ERROR_0XO0003.getMsg());
        }
    }

    @Override
    public Result login(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.error(ErrorCode.ERROR_0XO0001.getCode(), ErrorCode.ERROR_0XO0001.getMsg());
        }
        if (checkPassword(username, password)) {
            return Result.success();
        } else {
            return Result.error(ErrorCode.ERROR_0XO0004.getCode(), ErrorCode.ERROR_0XO0004.getMsg());
        }
    }

    private boolean checkUsernameValid(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPassword(String username, String password) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return false;
        } else {
            String salt = user.getSalt();
            String encryptPassword = user.getPassword();
            try {
                if (encryptPassword.equals(EncryptUtil.encryptSHA256(password, salt))) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

}
