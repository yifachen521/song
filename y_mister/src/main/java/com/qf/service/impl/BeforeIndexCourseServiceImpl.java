package com.qf.service.impl;

import com.qf.dao.BeforeIndexCourseDao;
import com.qf.pojo.Course;
import com.qf.pojo.Speaker;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;
import com.qf.service.BeforeIndexCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/20 19:02
 */
@Service
public class BeforeIndexCourseServiceImpl implements BeforeIndexCourseService {
    @Autowired
    private BeforeIndexCourseDao beforeIndexCourseDao;
    /**
     * 根据学科的id去查询 该学科下的所有的课程
     * @param id
     * @return
     */
    @Override
    public Subject findCourseIdBySubjectId(Integer id) {
        Subject byId = beforeIndexCourseDao.findById(id);

        List<Course> courseIdBySubjectId = beforeIndexCourseDao.findCourseIdBySubjectId(id);
        //返回两个课程 遍历两个课程 并拿他们的id去video表里查video
        for (Course course : courseIdBySubjectId) {
            //获取每个课程的id
            List<Video> videoByCourseId = beforeIndexCourseDao.findVideoByCourseId(course.getId());
            //遍历video集合
            for (Video video : videoByCourseId) {
                //查询到每个课程的讲师  把讲师set进每个video
                Speaker speakerByVideoId = beforeIndexCourseDao.findSpeakerByVideoId(Integer.parseInt(video.getSpeakerId()));
                video.setSpeaker(speakerByVideoId);
            }
            //视频集合放入课程
            course.setVideos(videoByCourseId);
        }
        //课程集合放入学科
        byId.setCourses(courseIdBySubjectId);
        return byId;
    }

    @Override
    public Video findVideoById(Integer id) {
        Video videoById = beforeIndexCourseDao.findVideoById(id);
        Speaker speakerByVideoId = beforeIndexCourseDao.findSpeakerByVideoId(Integer.parseInt(videoById.getSpeakerId()));
        videoById.setSpeaker(speakerByVideoId);

        return videoById;
    }

    @Override
    public Course findCourseById(Integer id) {
        Course courseById = beforeIndexCourseDao.findCourseById(id);
        return courseById;
    }




}
