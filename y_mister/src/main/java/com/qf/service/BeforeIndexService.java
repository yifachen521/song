package com.qf.service;

import com.qf.pojo.Subject;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 22:02
 */
public interface BeforeIndexService {
    /**
     * 学科的下拉菜单
     * @return
     */
    List<Subject> orderSubject();
}
