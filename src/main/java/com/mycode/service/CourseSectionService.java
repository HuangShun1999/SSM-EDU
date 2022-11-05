package com.mycode.service;

import com.mycode.domain.CourseSection;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author huangshun
* @description 针对表【course_section】的数据库操作Service
* @createDate 2022-10-31 18:31:33
*/
public interface CourseSectionService extends IService<CourseSection> {

    List<CourseSection> findSectionAndLesson(Integer course_id);
}
