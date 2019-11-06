package com.example.restwebservice.repository;

import com.example.restwebservice.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String > {
    List<Course> findByTopicId(String topicId);
}
