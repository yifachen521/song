package com.qf.dao;

import com.qf.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 21:59
 */
@Repository
public interface BeforeIndexDao {
    /**
     * 学科的下拉菜单
     * @return
     */
    List<Subject> orderSubject();

}
