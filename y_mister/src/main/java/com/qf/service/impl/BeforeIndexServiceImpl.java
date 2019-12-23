package com.qf.service.impl;

import com.qf.dao.BeforeIndexDao;
import com.qf.pojo.Subject;
import com.qf.service.BeforeIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 22:02
 */
@Service
public class BeforeIndexServiceImpl implements BeforeIndexService {
    @Autowired
    private BeforeIndexDao beforeIndexDao;
    /**
     * 学科的下拉菜单
     * @return
     */
    @Override
    public List<Subject> orderSubject() {
        List<Subject> subjects = beforeIndexDao.orderSubject();
        return subjects;
    }
}
