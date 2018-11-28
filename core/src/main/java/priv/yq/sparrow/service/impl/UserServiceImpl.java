package priv.yq.sparrow.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.yq.sparrow.entity.User;
import priv.yq.sparrow.repository.UserRepository;
import priv.yq.sparrow.service.UserService;

import java.util.List;

/**
 * Created by yaoqing on 2018/11/28.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean save(User user) {
        try {
            if (user == null) {
                return false;
            }
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("UserServiceImpl save error:{}", e);
            return false;
        }
    }

    @Override
    public Boolean save(List<User> users) {
        try {
            if (users == null || users.size() == 0) {
                return false;
            }
            userRepository.saveAll(users);
            return true;
        } catch (Exception e) {
            log.error("UserServiceImpl save list error:{}", e);
            return false;
        }
    }

    @Override
    public Boolean delete(User user) {
        try {
            if (user == null) {
                return false;
            }
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            log.error("UserServiceImpl delete error:{}", e);
            return false;
        }
    }

    @Override
    public Boolean delete(List<User> users) {
        try {
            if (users == null || users.size() == 0) {
                return false;
            }
            userRepository.deleteAll(users);
            return true;
        } catch (Exception e) {
            log.error("UserServiceImpl delete list error:{}", e);
            return false;
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            if (StringUtils.isBlank(username)) {
                return null;
            }
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            log.error("UserServiceImpl findByUsername error:{}", e);
            return null;
        }
    }

}
