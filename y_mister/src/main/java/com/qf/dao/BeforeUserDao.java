package com.qf.dao;

import com.qf.pojo.User;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.stereotype.Repository;

/**
 * @author 炜哥哥
 * @date 2019/12/20 8:34
 */
@Repository
public interface BeforeUserDao {
    /**
     * @param user
     * @return
     */
    User UserLogin(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    Integer updateUserMsg(User user);
    /**
     * 根据邮箱查询用户
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

    Integer addUser(User user);
}
