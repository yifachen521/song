package com.qf.service;

import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.utils.Page;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 16:56
 */
public interface ShowSpeakerListService {

    /**
     *查询讲师  返回讲师列表
     * @return
     */
    Page<Speaker> findSpeaker(Queryvo queryvo);

    /**
     * 删除讲师根据id
     * @param id
     * @return
     */
    boolean delSpeakerById(Integer id);

    /**
     * 添加讲师
     * @param speaker
     * @return
     */
    boolean addSpeaker(Speaker speaker);


    /**
     * 修改之查询回显
     * @param id
     * @return
     */
    Speaker updateFindById(Integer id);

    /**
     * 修改之保存
     * @param speaker
     * @return
     */
    boolean updateSaveSpeaker(Speaker speaker);
}
