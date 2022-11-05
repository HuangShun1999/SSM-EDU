package com.mycode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycode.domain.CourseLesson;
import com.mycode.service.CourseLessonService;
import com.mycode.mapper.CourseLessonMapper;
import org.springframework.stereotype.Service;

/**
* @author huangshun
* @description 针对表【course_lesson(课程节内容)】的数据库操作Service实现
* @createDate 2022-10-31 18:31:27
*/
@Service
public class CourseLessonServiceImpl extends ServiceImpl<CourseLessonMapper, CourseLesson>
    implements CourseLessonService{

}




