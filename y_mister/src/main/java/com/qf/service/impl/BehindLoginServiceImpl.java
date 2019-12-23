package com.qf.service.impl;

import com.qf.dao.BehindLoginDao;
import com.qf.pojo.Admin;
import com.qf.service.BehindLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 15:06
 */
@Service
public class BehindLoginServiceImpl implements BehindLoginService {
    @Autowired
    private BehindLoginDao behindLoginDao;

    /**
     *
     * @param admin
     * @return
     */
    @Override
    public boolean behindUserLogin(Admin admin) {
        List<Admin> admins = behindLoginDao.behindUserLogin(admin);
        if (admins.size()==1){
           //登录成功 查有此人
            return true;
        }
        //查无此人 登陆失败
        return false;
    }
}
