package com.qf.dao;

import com.qf.pojo.Course;
import com.qf.pojo.Speaker;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/20 19:01
 */
@Repository
public interface BeforeIndexCourseDao {

    /**
     * 根据学科的id去查询 该学科下的所有的课程
     * @param id
     * @return
     */
    List<Course> findCourseIdBySubjectId(Integer id);

    /**
     * 根据课程的id去查询 该课程下的所有的视屏
     * @param id
     * @return
     */
    List<Video> findVideoByCourseId( Integer id);

    /**
     *
     * @param id
     * @return
     */
    Speaker findSpeakerByVideoId(Integer id);

    Subject findById(Integer id);

    Video findVideoById(Integer id);

    Course findCourseById(Integer id);
}
