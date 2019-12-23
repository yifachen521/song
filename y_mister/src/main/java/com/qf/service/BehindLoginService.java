package com.qf.service;

import com.qf.pojo.Admin;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 15:06
 */
public interface BehindLoginService {
    /**
     *
     * @param admin
     * @return
     */
    boolean behindUserLogin(Admin admin);
}
