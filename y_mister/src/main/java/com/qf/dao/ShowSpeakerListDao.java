package com.qf.dao;

import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/19 16:58
 */
@Repository
public interface ShowSpeakerListDao {
    /**
     *查询讲师  返回讲师列表
     * @return
     */
    List<Speaker> findSpeaker(Queryvo queryvo);

    /**
     * 讲师总数
     * @return
     */
    Integer totalSpeaker();

    /**
     * 删除讲师根据id
     * @param id
     * @return
     */
    Integer delSpeakerById(Integer id);

    /**
     * 添加讲师
     * @param speaker
     * @return
     */
    Integer addSpeaker(Speaker speaker);

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
    Integer updateSaveSpeaker(Speaker speaker);
}
