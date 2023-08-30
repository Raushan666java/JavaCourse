package com.springest.springest.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springest.springest.Entity.Course;
import com.springest.springest.Service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {
	
	@Autowired
	private CourseService courseServices;

    @GetMapping("/home")
  
    public String home() {
    	return "hey dear";
    }
    
  
	@GetMapping("/course")
    @ResponseBody
     public List<Course>getCourse(){
		
    	return  this.courseServices.getCourse();
    	}
	
    @GetMapping("/course/{courseId}")
    @ResponseBody
    public Course getCourses(@PathVariable String courseId) {
    	return this.courseServices.getCourses(Long.parseLong(courseId));
    }
    @PostMapping("/course")
    @ResponseBody
    public Course AddCourse( @RequestBody Course course) {
    	
    	return this.courseServices.AddCourse(course);
    	
    }
    
    @PutMapping("/course")
    @ResponseBody
public Course UpdateCourse( @RequestBody Course course) {
    	
    	return this.courseServices.UpdateCourse(course);
    	
    }
    
    @DeleteMapping("/course/{courseId}")
    @ResponseBody
    public ResponseEntity<HttpStatus> DeleteCourse(@PathVariable String courseId){
    try{
    	this.courseServices.DeleteCourse(Long.parseLong(courseId));
    	return new ResponseEntity<>(HttpStatus.OK);
    }catch(Exception e) {
    	
    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

}
