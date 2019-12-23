package com.qf.service.impl;

import com.qf.dao.ShowVideoListDao;
import com.qf.pojo.Course;
import com.qf.pojo.Queryvo;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import com.qf.service.ShowVideoListService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 20:14
 */
@Service
public class ShowVideoListServiceImpl implements ShowVideoListService {

    @Autowired
    private ShowVideoListDao showListDao;
    /**
     *
     * @param queryvo
     * @return
     */
    @Override
    public Page<Video> findVideoByCondition(Queryvo queryvo) {

        //查询总条数
        Integer totalNumber = showListDao.findTotalNumber(queryvo);
        //计算查询开始的地方
        queryvo.setStart((queryvo.getPage()-1)*queryvo.getRows());
        //传入条件返回  分页后的数据集合
        List<Video> videoByCondition = showListDao.findVideoByCondition(queryvo);
        Page<Video> videoPage = new Page<Video>();
        //查询返回数据
        videoPage.setRows(videoByCondition);
        //数据总量
        videoPage.setTotal(totalNumber);
        //当前页
        videoPage.setPage(queryvo.getPage());
        //页容量
        videoPage.setSize(queryvo.getRows());
        return videoPage;
    }

    /**
     * 查询数据总条数
     * @param queryvo
     * @return
     */
    @Override
    public Integer findTotalNumber(Queryvo queryvo) {
        //查询总条数
        Integer totalNumber = showListDao.findTotalNumber(queryvo);
        return totalNumber;
    }

    /**
     * 查询所有讲师的名字填入下拉列表
     * @return
     */
    @Override
    public List<Speaker> findSpeakerList(){
        //讲师名字下拉列表
        List<Speaker> speakerList = showListDao.findSpeakerList();
        return speakerList;
    }

    /**
     * 查询课程列表填入下拉列表
     * @return
     */
    @Override
    public List<Course> findCourseList(){
        //课程的名称的下拉列表
        List<Course> courseList = showListDao.findCourseList();
        return courseList;
    }
    /**
     * 根据id来删除一条数据
     * @param video
     * @return
     */
    @Override
    public boolean delVideoById(Video video) {
        Integer integer = showListDao.delVideoById(video);
        if (integer==1){
            return true;
        }
        return false;
    }
    /**
     * 添加视屏
     * @param video
     * @return
     */
    @Override
    public boolean saveVideo(Video video) {
        Integer integer = showListDao.saveVideo(video);
        if (integer==1){
            return true;
        }
        return false;
    }
    /**
     * 修改之查询一条信息回填
     * @param id
     * @return
     */
    @Override
    public Video updateById(Integer id) {
        Video video = showListDao.updateById(id);
        return video;
    }
    /**
     * 修改后保存
     * @param video
     * @return
     */
    @Override
    public boolean updateSaveVideo(Video video) {
        Integer integer = showListDao.updateSaveVideo(video);
        if (integer==1){
            return true;
        }
        return false;
    }


}
