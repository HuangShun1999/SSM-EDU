package com.mycode.mapper;

import com.mycode.domain.CourseSection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author huangshun
* @description 针对表【course_section】的数据库操作Mapper
* @createDate 2022-10-31 18:31:33
* @Entity com.mycode.domain.CourseSection
*/
public interface CourseSectionMapper extends BaseMapper<CourseSection> {

    List<CourseSection> findSectionAndLesson(Integer course_id);
}




