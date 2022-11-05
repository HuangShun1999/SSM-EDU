package com.mycode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName course_section
 */
@TableName(value ="course_section")
@Data
public class CourseSection implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 章节名
     */
    private String sectionName;

    /**
     * 章节描述
     */
    private String description;

    /**
     * 记录创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDe;

    /**
     * 排序字段
     */
    private Integer orderNum;

    /**
     * 状态，0:隐藏；1：待更新；2：已发布
     */
    private Integer status;
    @TableField(exist = false)
    private List<CourseLesson> courseLessonList = new ArrayList<>();

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}