package com.qf.controller;

import com.qf.pojo.Subject;
import com.qf.service.BeforeIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 21:49
 */
@Controller
@RequestMapping("/subject")
public class BeforeIndex {
    @Autowired
    private BeforeIndexService beforeIndexService;
    /**
     * 跳转首页 回填 学科的下拉菜单
     * @return
     */
    @RequestMapping("/selectAll")
    public  String selectAll(HttpServletRequest request){
        List<Subject> subjects = beforeIndexService.orderSubject();
        request.getSession().setAttribute("subjectList",subjects);

        return  "before/index";
    }


}
