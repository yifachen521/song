package com.qf.controller;

import com.qf.pojo.Course;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;
import com.qf.service.BeforeIndexCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/20 22:27
 */
@Controller
@RequestMapping("/video")
public class BeforeIndexVideo {
    @Autowired
    private BeforeIndexCourseService beforeIndexCourseService;

    @RequestMapping("/showVideo")
    public  String showVideo(Integer videoId, String subjectName, HttpServletRequest request, Model model){
        //从session中拿出指定subject
        Subject subject = (Subject) request.getSession().getAttribute("subject");
        System.out.println(subjectName+"subjectName----");
        //subjectName存入model
        model.addAttribute("subjectName",subjectName);
        //根据video的id查询这个video  和其对应的课程
        Video videoById = beforeIndexCourseService.findVideoById(videoId);
        System.out.println(videoById.toString()+"videoById----");

        //将这个video对象放入model
        model.addAttribute("video",videoById);
        //根据这个video的课程编号去查询该课程
        List<Course> courses = subject.getCourses();
        for (Course cours : courses) {
            if (cours.getId().equals(videoById.getCourseId())){
                //将这个video对象放入model
                System.out.println(cours.toString()+"cours--111--");
                model.addAttribute("course",cours);
            }
        }
        return "before/section";
    }

}
