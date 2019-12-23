package com.qf.dao;

import com.qf.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 14:51
 */
@Repository
public interface BehindLoginDao {
    /**
     * 根据用户名和密码进行用户后台登录
     * @param admin
     * @return
     */
    List<Admin> behindUserLogin(Admin admin);
}
