package com.springest.springest.Service;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springest.springest.Dao.CourseDoa;
import com.springest.springest.Entity.Course;
@Service 
public class CourseServiceImp implements CourseService {
	
	@Autowired
	private CourseDoa courseDoa;
	
     //List<Course>list;
         
         public CourseServiceImp() {
        	// list=new ArrayList<>();
        	// list.add(new Course(145,"java core course","thsi courese control"));
        	// list.add(new Course(4343,"spring boot courser","Creating spring boot app"));
        			 
				
         }

         @Override
     	public List<Course> getCourse() {
     		
     		return courseDoa.findAll();
     	}
			/*
			 * public List<Course> getCourses(){
			 * 
			 * return courseDoa.findAll();
			 * 
			 * }
			 */
			 // @Override
			//  public List<Course> getCourse() {
			//		// TODO Auto-generated method stub
			//		return list;
			//	}
			@Override
			  public Course getCourses(long courseId) 
			  {
				//  Course c=null;
				//  for(Course course:list) {
				//	  if(course.getId()==courseId) {
			//	//		  c=course;
				//		  break;
				//		  
				//	  }
				//  }
			    //       return c; 
			      return courseDoa.getOne(courseId);     
			  }
			
	public Course AddCourse(Course course) {
	//	list.add(course);
	//	return course;
		courseDoa.save(course);
		return course;
	}


	@Override
	public void DeleteCourse(long parseLong) {
		////list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course Entity=courseDoa.getOne(parseLong);
		courseDoa.delete(Entity);
	}


	@Override
	public Course UpdateCourse(Course course) {
		//list.forEach(e->{
		//	if(e.getId()==course.getId()) {
		//		e.setTitle(course.getTitle());
		//		e.setDescription(course.getDescription());
		//	}
		//});
		//return course;
		courseDoa.save(course);
		return course;
	}


	
	

	
}
