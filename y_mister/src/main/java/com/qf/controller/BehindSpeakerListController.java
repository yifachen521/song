package com.qf.controller;

import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.service.ShowSpeakerListService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 炜哥哥
 * @date 2019/12/19 16:53
 */
@Controller
@RequestMapping("speaker")
public class BehindSpeakerListController {
    @Autowired
    private ShowSpeakerListService showSpeakerListService;

    /**
     * 查询讲师 并分页
     *
     * @param queryvo
     * @param model
     * @return
     */
    @RequestMapping("/showSpeakerList")
    public String showSpeakerList(Queryvo queryvo, Model model) {
        //查询
        Page<Speaker> speaker =
                showSpeakerListService.findSpeaker(queryvo);
        model.addAttribute("page", speaker);
        return "behind/speakerList";
    }

    /**
     * 根据id删除讲师
     *
     * @param id
     * @return
     */
    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(Integer id) {
        boolean b = showSpeakerListService.delSpeakerById(id);
        if (b) {
            return "success";
        }
        return "error";
    }

    /**
     * 跳转添加讲师
     *
     * @param
     * @return
     */
    @RequestMapping("/addSpeaker")
    public String addSpeaker() {
        return "behind/addSpeaker";
    }

    /**
     * 添加或修改讲师
     *
     * @param speaker
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker) {
        if(speaker.getId()!=null && !"".equals(speaker.getId())){
            //表示是修改
            showSpeakerListService.updateSaveSpeaker(speaker);
        }else {
            //表示添加
        showSpeakerListService.addSpeaker(speaker);
        }
        return "redirect:showSpeakerList";
    }

    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        //先去根据这个id去查询这个讲师
        Speaker speaker = showSpeakerListService.updateFindById(id);
        model.addAttribute("speaker",speaker);
        return "behind/addSpeaker";
    }

}
