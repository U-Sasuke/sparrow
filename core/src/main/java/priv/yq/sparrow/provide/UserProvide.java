package priv.yq.sparrow.provide;

import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * Created by yaoqing on 2018/11/28.
 */
@Component
public class UserProvide implements UserRest{

    private static Logger log = LoggerFactory.getLogger(UserProvide.class);

    @Autowired
    private UserService userService;

    @Override
    public Result register(String dataJson) {
        if(StringUtils.isBlank(dataJson)){
            return Result.error(ErrorCode.ERROR_OXOA001.getCode(),ErrorCode.ERROR_OXOA001.getMsg());
        }
        UserDTO userDTO;
        try{
            userDTO = new ObjectMapper().readValue(dataJson,UserDTO.class);
        }catch (Exception e){
            return Result.error(ErrorCode.ERROR_OXOA002.getCode(),ErrorCode.ERROR_OXOA002.getMsg());
        }
        if(StringUtils.isBlank(userDTO.getUsername()) && StringUtils.isBlank(userDTO.getPassword())){
            return Result.error(ErrorCode.ERROR_OXOA001.getCode(),ErrorCode.ERROR_OXOA001.getMsg());
        }
        if(checkUsernameValid(userDTO.getUsername())){
            User user = new User();
            BeanUtils.copyProperties(user,userDTO);
//            user.setPassword(userDTO.getPassword().);
        }


        return null;
    }

    private boolean checkUsernameValid(String username){
        if(StringUtils.isBlank(username)){
            return false;
        }
        User user = userService.findByUsername(username);
        if(user == null){
            return true;
        }else{
            return false;
        }
    }
}
