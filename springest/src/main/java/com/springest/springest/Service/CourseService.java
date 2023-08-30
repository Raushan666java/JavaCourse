package com.springest.springest.Service;

import java.util.List;

import com.springest.springest.Entity.Course;

public interface CourseService {

	
	public List<Course> getCourse();

	public Course getCourses(long courseId);

	public Course AddCourse(Course course);

	public void DeleteCourse(long parseLong);

	public Course UpdateCourse(Course course);
	
	
}
