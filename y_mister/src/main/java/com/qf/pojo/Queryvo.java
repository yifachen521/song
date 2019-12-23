package com.qf.pojo;

import java.io.Serializable;

/**
 * @author 炜哥哥
 * @date 2019/12/18 17:44
 */
public class Queryvo implements Serializable {
    private String title;
    private String speakerId;
    private String speakerName;
    private Integer courseId;
    //分页查询开始的地方
    private  Integer  start=0;
    //每页查询的条数
    private  Integer rows=5;
    //当前页码
    private  Integer page=1;

    public Queryvo() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(String speakerId) {
        this.speakerId = speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Queryvo{" +
                "title='" + title + '\'' +
                ", speakerId='" + speakerId + '\'' +
                ", speakerName='" + speakerName + '\'' +
                ", courseId=" + courseId +
                ", start=" + start +
                ", rows=" + rows +
                ", page=" + page +
                '}';
    }
}
