/**
 * 
 */
package com.jdbc.prjoject.jdbcproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jdbc.prjoject.jdbcproject.Course;

/**
 * @author ggoller
 *
 */
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner 
{
	@Autowired
	private CourseJdbcRepository courseJdbcRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception 
	{
		courseJdbcRepository.insertCourse(new Course(1,"SQL","HackerRank"));
		courseJdbcRepository.insertCourse(new Course(2,"Spring","Udemy"));
		courseJdbcRepository.insertCourse(new Course(3,"DevOps","Coursera"));
		courseJdbcRepository.deleteCourseById(2);
		System.out.println(courseJdbcRepository.findCourseById(1));
	}
}
