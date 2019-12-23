package com.qf.service.impl;

import com.qf.dao.ShowCourseListDao;
import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Subject;
import com.qf.service.ShowCourseListService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 20:09
 */
@Service
public class ShowCourseListServiceImpl implements ShowCourseListService {
    @Autowired
    private ShowCourseListDao showCourseListDao;

    /**
     * 查询所有课程
     *
     * @return
     */
    @Override
    public Page<Course> findAll(Queryvo queryvo) {
        //查寻数据总数
        Integer integer = showCourseListDao.totalCourse();
        Page<Course> page = new Page<>();
        //设置查询的起始条件
        queryvo.setStart((queryvo.getPage() - 1) * queryvo.getRows());
        List<Course> all = showCourseListDao.findAll(queryvo);
        page.setSize(queryvo.getRows());
        page.setPage(queryvo.getPage());
        page.setTotal(integer);
        page.setRows(all);
        return page;
    }
    /**
     * 根据id来删除课程
     * @param id
     * @return
     */
    @Override
    public boolean delCourseById(Integer id) {
        Integer integer = showCourseListDao.delCourseById(id);
        if(integer==1){
            return  true;
        }
        return false;
    }
    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public boolean addCourse(Course course) {
        Integer integer = showCourseListDao.addCourse(course);
        if (integer==1){
            return  true;
        }
        return false;
    }
    /**
     * 回填的科目 的下拉菜单
     * @return
     */
    @Override
    public List<Subject> order() {
        List<Subject> order = showCourseListDao.order();
        return order;
    }

    /**
     * 保存之回填对象
     * @param id
     * @return
     */
    @Override
    public Course updateById(Integer id) {
        Course course = showCourseListDao.updateById(id);
        return course;
    }

    /**
     * 保存之保存
     * @return
     */
    @Override
    public boolean updateSaveSubject(Course course) {
        Integer integer = showCourseListDao.updateSaveSubject(course);
        if (integer==1){
            return  true;
        }
        return false;
    }
}
