package com.mycode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 课程节内容
 * @TableName course_lesson
 */
@TableName(value ="course_lesson")
@Data
public class CourseLesson implements Serializable {
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
     * 章节id
     */
    private Integer sectionId;

    /**
     * 课时主题
     */
    private String theme;

    /**
     * 课时时长(分钟)
     */
    private Integer duration;

    /**
     * 是否免费
     */
    private Integer isFree;

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
    private Integer isDel;

    /**
     * 排序字段
     */
    private Integer orderNum;

    /**
     * 课时状态,0-隐藏，1-未发布，2-已发布
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}