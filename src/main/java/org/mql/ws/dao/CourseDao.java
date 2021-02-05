package org.mql.ws.dao;

import java.util.List;

import org.mql.ws.models.Course;

public interface CourseDao {
	int add(Course course);
	Course get(String id);
	public List<Course> getMatches(Course course);
}
