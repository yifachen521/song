package com.qf.service.impl;

import com.qf.dao.ShowSpeakerListDao;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.service.ShowSpeakerListService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 16:57
 */
@Service
public class ShowSpeakerListServiceImpl implements ShowSpeakerListService {
    @Autowired
    private ShowSpeakerListDao showSpeakerListDao;

    /**
     * 查询讲师  返回讲师列表  分页查询
     *
     * @return
     */
    @Override
    public Page<Speaker> findSpeaker(Queryvo queryvo) {
        //讲师总数
        Integer integer = showSpeakerListDao.totalSpeaker();
        //开始查询的地方和每页展示多少条数据
        queryvo.setStart((queryvo.getPage() - 1) * queryvo.getRows());
        List<Speaker> speaker = showSpeakerListDao.findSpeaker(queryvo);

        Page<Speaker> page = new Page<>();
        //查询的讲师的集合
        page.setRows(speaker);
        //总讲师数
        page.setTotal(integer);
        //当前页
        page.setPage(queryvo.getPage());
        //页容量
        page.setSize(queryvo.getRows());
        return page;
    }

    /**
     * 删除讲师根据id
     *
     * @param id
     * @return
     */
    @Override
    public boolean delSpeakerById(Integer id) {

        Integer integer = showSpeakerListDao.delSpeakerById(id);
        if (integer == 1) {
            return true;
        }
        return false;
    }
    /**
     * 添加讲师
     * @param speaker
     * @return
     */
    @Override
    public boolean addSpeaker(Speaker speaker) {
        Integer integer = showSpeakerListDao.addSpeaker(speaker);
        if (integer==1){
            return true;
        }
        return false;
    }

    /**
     * 修改之查询回显
     * @param id
     * @return
     */
    @Override
    public Speaker updateFindById(Integer id) {
        Speaker speaker = showSpeakerListDao.updateFindById(id);
        return speaker;
    }
    /**
     * 修改之保存
     * @param speaker
     * @return
     */
    @Override
    public boolean updateSaveSpeaker(Speaker speaker) {
        Integer integer = showSpeakerListDao.updateSaveSpeaker(speaker);
        if(integer==1){
            return true;
        }
        return false;
    }

}
