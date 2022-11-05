package com.mycode.controller;

import com.github.pagehelper.PageInfo;
import com.mycode.domain.Course;
import com.mycode.domain.RequestData;
import com.mycode.domain.RespondData;
import com.mycode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/findAllCourse")
    public RespondData findAllCourse(@RequestBody RequestData requestData) {
        try {
            PageInfo<Course> allCourse = courseService.findAllCourse(requestData);
            return RespondData.success(allCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondData.error("查询失败");
        }
    }


    @CrossOrigin
    @PostMapping("/courseUpload")
    public RespondData courseUpload(@RequestBody MultipartFile file, HttpServletRequest request) {
        //获取原文件名，获取项目路径，截取到指定路径，截取文件后缀名，获取当前年月日，获取uuid作为文件名，拼接路径+日期+文件名+后缀
        //存储图片，返回图片路径加文件名。
        //获取upload所在包的绝对路径
        String uploadPath = request.getServletContext().getRealPath("/");
        uploadPath = uploadPath.substring(0, uploadPath.indexOf("/target"));
        //获取到upload目录的绝对路径
        uploadPath += "/src/main/webapp/upload";
        //获取当前的年月日 作为upload目录的子目录的名称
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        //上传文件的名称：就是随机数
        String fileName = UUID.randomUUID().toString();
        //获取上传文件的真实的后缀名  作为上传后的文件的后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));


        //上传图片的最终路径
        File targetFile = new File(uploadPath, year + "/" + month + "/" + date + "/" + fileName + suffix);

        try {
            //将上传图片的内容写到我们制定的最终路径
            file.transferTo(targetFile);
            Map<String, Object> map = new HashMap<>();
            map.put("filename", fileName + suffix);
            map.put("filepath", "http://localhost:8080/upload/" + year + "/" + month + "/" + date + "/" + fileName + suffix);
            return RespondData.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondData.error("上传失败");
        }
    }

    @PostMapping("/saveOrUpdateCourse")
    public RespondData saveOrUpdateCourse(@RequestBody Course course) {
        try {if(course.getId()==null){
            course.setCreateTime(new Date());
        }else {
            course.setUpdateTime(new Date());
        }
            courseService.saveOrUpdate(course);
            return RespondData.success();
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error(e.getMessage());
        }

    }


    @GetMapping("/findCourseById")
    public RespondData findCourseById(Integer id){
        try {
            Course byId = courseService.getById(id);
            return RespondData.success(byId);
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }
    }

    @GetMapping("/updateCourseStatus")
    public RespondData updateCourseStatus(Course course){
        try {
            courseService.updateById(course);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status",course.getStatus());
            return RespondData.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error("响应失败");
        }
    }
}
