package com.qf.controller;

import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import com.qf.service.ShowVideoListService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 16:57
 */
@Controller
@RequestMapping("video")
public class BehindVedioListController {

    @Autowired
    private ShowVideoListService showListService;

    /**
     * 查询数据
     * @param queryvo
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Queryvo queryvo, Model model) {
        Page<Video> videoByCondition = showListService.findVideoByCondition(queryvo);
        //展示到页面的数据
        model.addAttribute("page", videoByCondition);
        //回填下拉列表
        //讲师名字下拉列表
        List<Speaker> speakerList = showListService.findSpeakerList();
        model.addAttribute("speakerList", speakerList);
        //课程的名称的下拉列表
        List<Course> courseList = showListService.findCourseList();
        model.addAttribute("courseList", courseList);
        //标题回填
        model.addAttribute("queryVo", queryvo);
        return "behind/videoList";

    }

    /**
     * 根据id删除一条数据
     * @param id
     * @return
     */
    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(Integer id) {
        Video video = new Video();
        video.setId(id);
        boolean b = showListService.delVideoById(video);
        if (b) {
            return "success";
        }
        return "error";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(int[] ids) {
        Video video = new Video();
        for (int i : ids) {
            video.setId(i);
            showListService.delVideoById(video);
        }
        return "redirect:list";
    }

    /**
     * 去添加页面
     * @return
     */
    @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        //带上下拉列表回填的信息
        //讲师名字下拉列表
        List<Speaker> speakerList = showListService.findSpeakerList();
        model.addAttribute("speakerList", speakerList);
        //课程的名称的下拉列表
        List<Course> courseList = showListService.findCourseList();
        model.addAttribute("courseList", courseList);
        return "behind/addVideo";
    }

    /**
     * 添加视屏
     * @param video
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video) {
        if (video.getId() != null && !"".equals(video.getId())) {
            showListService.updateSaveVideo(video);
        } else {
            //保存的过程
            showListService.saveVideo(video);
        }
        //保存成功  从定向到查询
        return "redirect:list";
    }


    /**
     * 修改信息之回填
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        //查询回填信息  并跳转
        Video video = showListService.updateById(id);
        model.addAttribute("video", video);
        //带上下拉列表回填的信息
        //讲师名字下拉列表
        List<Speaker> speakerList = showListService.findSpeakerList();
        model.addAttribute("speakerList", speakerList);
        //课程的名称的下拉列表
        List<Course> courseList = showListService.findCourseList();
        model.addAttribute("courseList", courseList);
        return "behind/addVideo";
    }


}
