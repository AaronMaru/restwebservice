package com.example.restwebservice.repository;

import com.example.restwebservice.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String > {
}
