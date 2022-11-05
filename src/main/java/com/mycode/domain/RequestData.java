package com.mycode.domain;

import lombok.Data;

@Data
public class RequestData {
    private Integer currentPage;//分页数据 当前显示的页数
    private Integer pageSize;//分页数据  当前每页显示条数
    private String courseName;//查询条件 模糊查询
    private Integer status;//查询条件  状态查询
}
