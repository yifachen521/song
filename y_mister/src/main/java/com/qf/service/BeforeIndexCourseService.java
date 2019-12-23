package com.qf.service;

import com.qf.pojo.Course;
import com.qf.pojo.Speaker;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/20 19:01
 */
public interface BeforeIndexCourseService {

    /**
     * 根据学科的id去查询 该学科下的所有的课程
     * @param id
     * @return
     */
    Subject findCourseIdBySubjectId(Integer id);

    Video findVideoById(Integer id);

    Course findCourseById(Integer id);


}
