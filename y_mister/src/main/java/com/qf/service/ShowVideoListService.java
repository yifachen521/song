package com.qf.service;

import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import com.qf.utils.Page;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 20:13
 */
public interface ShowVideoListService {
    /**
     *
     * @param queryvo
     * @return
     */
    Page<Video> findVideoByCondition(Queryvo queryvo);

    /**
     * 查询数据总条数
     * @param queryvo
     * @return
     */
    Integer findTotalNumber(Queryvo queryvo);

    /**
     * 查询所有讲师的名字填入下拉列表
     * @return
     */
    List<Speaker> findSpeakerList();

    /**
     * 查询课程列表填入下拉列表
     * @return
     */
    List<Course> findCourseList();

    /**
     * 根据id来删除一条数据
     * @param video
     * @return
     */
     boolean delVideoById(Video video);

    /**
     * 添加视屏
     * @param video
     * @return
     */
    boolean saveVideo(Video video);

    /**
     * 修改之查询一条信息回填
     * @param id
     * @return
     */
    Video updateById(Integer id);

    /**
     * 修改后保存
     * @param video
     * @return
     */
    boolean updateSaveVideo(Video video);
}
