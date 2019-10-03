package com.example.restwebservice.controller;

import com.example.restwebservice.model.Course;
import com.example.restwebservice.model.Topic;
import com.example.restwebservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> index(@PathVariable String id) {
        return courseService.getAll();
    }

    @RequestMapping("/topics/{id}")
    public Course show(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicID}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicID}/courses/{id}")
    public void update(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicID}/courses/{id}")
    public void destroy(@PathVariable String topicId) {
        courseService.deleteCourse(topicId);
    }
}
