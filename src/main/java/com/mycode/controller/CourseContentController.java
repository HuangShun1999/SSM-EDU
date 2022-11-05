package com.mycode.controller;

import com.mycode.domain.Course;
import com.mycode.domain.CourseLesson;
import com.mycode.domain.CourseSection;
import com.mycode.domain.RespondData;
import com.mycode.mapper.CourseLessonMapper;
import com.mycode.service.CourseLessonService;
import com.mycode.service.CourseSectionService;
import com.mycode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {


    @Autowired
    private CourseSectionService courseSectionService;
    @Autowired
    private CourseService courseService;
    @Autowired
   private CourseLessonService courseLessonService;

    @GetMapping("/findSectionAndLesson")
    public RespondData findSectionAndLesson(Integer courseId){
        try {
            List<CourseSection> sectionAndLesson = courseSectionService.findSectionAndLesson(courseId);
            return RespondData.success(sectionAndLesson);
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }
    }

    @GetMapping("/findCourseByCourseId")
    public RespondData findCourseById(Integer courseId){
        try {
            Course byId = courseService.getById(courseId);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("id",byId.getId());
            map.put("courseName",byId.getCourseName());
            return RespondData.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }
    }

    @PostMapping("/saveOrUpdateSection")
    public RespondData saveOrUpdateSection(@RequestBody CourseSection courseSection){
        try {
            if(courseSection.getId()==null){
                courseSection.setCreateTime(new Date());
            }else {
                courseSection.setUpdateTime(new Date());
            }
            courseSectionService.saveOrUpdate(courseSection);
            return RespondData.success();
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }

    }


    @GetMapping("/updateSectionStatus")
    public RespondData updateSectionStatus(CourseSection courseSection){
        try {
            courseSectionService.updateById(courseSection);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status",courseSection.getStatus());
            return RespondData.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }
    }

    @PostMapping("/saveLesson")
    public RespondData saveLesson(@RequestBody CourseLesson courseLesson){
        try {
            courseLessonService.save(courseLesson);
            return RespondData.success();
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }
    }
}
