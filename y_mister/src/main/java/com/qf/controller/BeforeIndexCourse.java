package com.qf.controller;

import com.qf.pojo.Course;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;
import com.qf.service.BeforeIndexCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/20 19:00
 */
@Controller
@RequestMapping("/course")
public class BeforeIndexCourse {

    @Autowired
    private BeforeIndexCourseService beforeIndexCourseService;

    @RequestMapping("/course/{id}")
    public String  course(@PathVariable("id") Integer id, HttpServletRequest request){
       //根据这个id去数据库查询响应的学科 根据学科的外键  查询课程  遍历出来该学科下的课程展示到页面
      //再拿出课程的视屏外键  去查询视频的集合 展示到页面上
        Subject courseIdBySubjectId = beforeIndexCourseService.findCourseIdBySubjectId(id);
        request.getSession().setAttribute("subject",courseIdBySubjectId);
        return "before/course";
    }

}
