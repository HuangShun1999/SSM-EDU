package com.mycode.mapper;

import com.mycode.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycode.domain.RequestData;
import com.mycode.domain.RespondData;

import java.util.List;

/**
* @author huangshun
* @description 针对表【course】的数据库操作Mapper
* @createDate 2022-10-31 17:45:45
* @Entity com.mycode.domain.Course
*/
public interface CourseMapper extends BaseMapper<Course> {
List<Course> findAllCourse(RequestData requestData);
}




