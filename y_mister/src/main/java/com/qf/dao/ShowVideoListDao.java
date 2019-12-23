package com.qf.dao;

import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 19:37
 */
@Repository
public interface ShowVideoListDao {
    /**
     * 根据条件来查询要展示的数据
     * @param queryvo
     * @return
     */
    List<Video> findVideoByCondition(Queryvo queryvo);

    /**
     * 查询总数据条数
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
    Integer delVideoById(Video video);

    /**
     * 添加视屏
     * @param video
     * @return
     */
    Integer saveVideo(Video video);

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
    Integer updateSaveVideo(Video video);
}
