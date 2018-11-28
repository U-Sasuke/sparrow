package priv.yq.sparrow.service;

import priv.yq.sparrow.entity.User;

import java.util.List;

/**
 * Created by yaoqing on 2018/11/28.
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @param user 用户
     */
    Boolean save(User user);

    /**
     * 保存用户列表
     *
     * @param users 用户列表
     */
    Boolean save(List<User> users);

    /**
     * 删除用户
     *
     * @param user 用户
     */
    Boolean delete(User user);

    /**
     * 删除用户列表
     *
     * @param users 用户列表
     */
    Boolean delete(List<User> users);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     */
    User findByUsername(String username);

}
