package com.mycode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycode.domain.CourseSection;
import com.mycode.service.CourseSectionService;
import com.mycode.mapper.CourseSectionMapper;
import com.mycode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huangshun
* @description 针对表【course_section】的数据库操作Service实现
* @createDate 2022-10-31 18:31:33
*/
@Service
public class CourseSectionServiceImpl extends ServiceImpl<CourseSectionMapper, CourseSection>
    implements CourseSectionService{


    @Autowired
    private CourseSectionMapper courseSectionMapper;


    @Override
    public List<CourseSection> findSectionAndLesson(Integer course_id) {
        List<CourseSection> sectionAndLesson = courseSectionMapper.findSectionAndLesson(course_id);
        return sectionAndLesson;
    }
}




