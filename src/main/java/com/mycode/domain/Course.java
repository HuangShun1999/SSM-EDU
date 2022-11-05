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
 * 
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 课程一句话简介
     */
    private String brief;

    /**
     * 原价
     */
    private Double price;

    /**
     * 原价标签
     */
    private String priceTag;

    /**
     * 优惠价
     */
    private Double discounts;

    /**
     * 优惠标签
     */
    private String discountsTag;

    /**
     * 描述markdown
     */
    private String courseDescriptionMarkDown;

    /**
     * 课程描述
     */
    private String courseDescription;

    /**
     * 课程分享图片url
     */
    private String courseImgUrl;

    /**
     * 是否新品
     */
    private Integer isNew;

    /**
     * 广告语
     */
    private String isNewDes;

    /**
     * 最后操作者
     */
    private Integer lastOperatorId;

    /**
     * 自动上架时间
     */
    private Date autoOnlineTime;

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
     * 总时长(分钟)
     */
    private Integer totalDuration;

    /**
     * 课程列表展示图片
     */
    private String courseListImg;

    /**
     * 课程状态，0-草稿，1-上架
     */
    private Integer status;

    /**
     * 课程排序，用于后台保存草稿时用到
     */
    private Integer sortNum;

    /**
     * 课程预览第一个字段
     */
    private String previewFirstField;

    /**
     * 课程预览第二个字段
     */
    private String previewSecondField;

    /**
     * 销量
     */
    private Integer sales;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}