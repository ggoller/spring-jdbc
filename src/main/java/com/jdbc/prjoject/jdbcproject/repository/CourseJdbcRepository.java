package com.jdbc.prjoject.jdbcproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.prjoject.jdbcproject.Course;

@Repository
public class CourseJdbcRepository 
{
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_COURSE_QUERY="INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(?,?,?)";
	private static String DELETE_COURSE_QUERY="DELETE COURSE WHERE ID=?";
	private static String SELECT_COURSE_QUERY="SELECT * FROM COURSE WHERE ID=?";
	
	public void insertCourse(Course course)
	{
		springJdbcTemplate.update(INSERT_COURSE_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteCourseById(long id)
	{
		springJdbcTemplate.update(DELETE_COURSE_QUERY,id);
	}
	
	public Course findCourseById(long id)
	{
		return springJdbcTemplate.queryForObject(SELECT_COURSE_QUERY, new BeanPropertyRowMapper<>(Course.class), id) ;
	}	
}
