package com.qf.dao;

import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 20:04
 */
@Repository
public interface ShowCourseListDao {
    /**
     * 查询所有课程
     * @return
     */
    List<Course> findAll(Queryvo queryvo);

    /**
     * 总课程数
     * @return
     */
    Integer totalCourse();

    /**
     * 根据id来删除课程
     * @param id
     * @return
     */
    Integer delCourseById(Integer id);

    /**
     * 添加课程
     * @param course
     * @return
     */
    Integer addCourse(Course course);

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
     * @param course
     * @return
     */
    Integer updateSaveSubject(Course course);
}
