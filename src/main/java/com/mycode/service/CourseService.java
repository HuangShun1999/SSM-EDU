package com.mycode.service;

import com.github.pagehelper.PageInfo;
import com.mycode.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mycode.domain.RequestData;
import com.mycode.domain.RespondData;

/**
* @author huangshun
* @description 针对表【course】的数据库操作Service
* @createDate 2022-10-31 17:45:45
*/
public interface CourseService extends IService<Course> {

    PageInfo<Course> findAllCourse(RequestData requestData);

}
