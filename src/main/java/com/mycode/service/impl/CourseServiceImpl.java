package com.mycode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycode.domain.Course;
import com.mycode.domain.RequestData;
import com.mycode.domain.RespondData;
import com.mycode.exception.MyException;
import com.mycode.service.CourseService;
import com.mycode.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huangshun
* @description 针对表【course】的数据库操作Service实现
* @createDate 2022-10-31 17:45:45
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    public PageInfo<Course> findAllCourse(RequestData requestData) {
        PageHelper.startPage(requestData.getCurrentPage(),requestData.getPageSize());
        List<Course> allCourse = courseMapper.findAllCourse(requestData);
        PageInfo<Course> coursePageInfo = new PageInfo<Course>(allCourse);
        return coursePageInfo;
    }

}




