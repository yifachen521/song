package com.qf.service;

import com.qf.pojo.User;

/**
 * @author 炜哥哥
 * @date 2019/12/20 8:35
 */
public interface BeforeUserService {

    /***
     *
     * @param user
     * @return
     */
    User UserLogin(User user);
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer updateUserMsg(User user);
    /**
     * @param user
     * @return
     */
    User findUser(User user);
    /**
     * 用户修改头像
     * @return
     */
    Integer updateUserImg(User user);

    /**
     * 修改密码
     * @return
     */
    Integer updateUserPwd(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    Integer addUser(User user);
}
