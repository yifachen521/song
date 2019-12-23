package com.qf.service;

import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Subject;
import com.qf.utils.Page;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 20:08
 */
public interface ShowCourseListService {
    /**
     * 查询所有课程
     * @return
     */
    Page<Course> findAll(Queryvo queryvo);
    /**
     * 根据id来删除课程
     * @param id
     * @return
     */
    boolean delCourseById(Integer id);


    /**
     * 添加课程
     * @param course
     * @return
     */
    boolean addCourse(Course course);

    /**
     * 回填的科目 的下拉菜单
     * @return
     */
    List<Subject> order();
    /**
     *
     * @return
     */
    Course updateById(Integer id);

    /**
     * 修改之保存
     * @return
     */
    boolean updateSaveSubject(Course course);

}
