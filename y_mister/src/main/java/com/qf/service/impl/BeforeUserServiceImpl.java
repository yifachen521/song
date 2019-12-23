package com.qf.service.impl;

import com.qf.dao.BeforeUserDao;
import com.qf.pojo.User;
import com.qf.service.BeforeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 炜哥哥
 * @date 2019/12/20 8:36
 */
@Service
public class BeforeUserServiceImpl implements BeforeUserService {
    @Autowired
    private BeforeUserDao beforeUserDao;

    /***
     *用户登录
     * @param user
     * @return
     */
    @Override
    public User UserLogin(User user) {
        User user1 = beforeUserDao.UserLogin(user);
        return user1;
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public Integer updateUserMsg(User user) {
        Integer integer = beforeUserDao.updateUserMsg(user);
        return integer;
    }

    /**
     * 查询用户
     * @param user
     * @return
     */
    @Override
    public User findUser(User user) {
        User user1 = beforeUserDao.findUser(user);
        return user1;
    }
    /**
     * 用户修改头像
     * @return
     */
    @Override
    public Integer updateUserImg(User user) {
        Integer integer = beforeUserDao.updateUserImg(user);
        return integer;
    }
    /**
     * 修改密码
     * @return
     */
    @Override
    public Integer updateUserPwd(User user) {
        Integer integer = beforeUserDao.updateUserPwd(user);
        return integer;
    }

    @Override
    public Integer addUser(User user) {
        Integer integer = beforeUserDao.addUser(user);
        return integer;
    }


}
