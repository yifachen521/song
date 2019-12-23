package com.qf.controller;

import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Subject;
import com.qf.service.ShowCourseListService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 19:18
 */
@Controller
@RequestMapping("course")
public class BehindCourseListController {
    @Autowired
    private ShowCourseListService showCourseListService;

    /**
     * c查询课程
     *
     * @param queryvo
     * @param model
     * @return
     */
    @RequestMapping("/showCourseList")
    public String showCourseList(Queryvo queryvo, Model model) {
        //查询并分页
        Page<Course> all = showCourseListService.findAll(queryvo);
        model.addAttribute("page", all);
        return "behind/courseList";
    }

    /**
     * 根据id来删课程
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/courseDel")
    public String courseDel(Integer id) {
        boolean b = showCourseListService.delCourseById(id);
        if (b) {
            return "success";
        }
        return "error";
    }

    /**
     * 跳转添加页面 需要回填一个科目的下拉菜单
     * @return
     */
    @RequestMapping("/addCourse")
    public String addCourse(Model model) {
        List<Subject> order = showCourseListService.order();
        model.addAttribute("subjectList",order);
        return  "behind/addCourse";
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Course course){
        if (course.getId()!=null && !"".equals(course.getId())){
            showCourseListService.updateSaveSubject(course);
        }else {
        showCourseListService.addCourse(course);
        }
        return "redirect:showCourseList";
    }

    /**
     * 修改回填数据
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public  String edit(Integer id,Model model){
        Course course = showCourseListService.updateById(id);
        model.addAttribute("course",course);
        List<Subject> order = showCourseListService.order();
        model.addAttribute("subjectList",order);
        return "behind/addCourse";
    }

}
