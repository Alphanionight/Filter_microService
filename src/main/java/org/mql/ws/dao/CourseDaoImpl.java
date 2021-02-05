package org.mql.ws.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.mql.ws.models.Course;

public class CourseDaoImpl implements CourseDao {

	private Hashtable<String, Course> courses;
	private static CourseDaoImpl instance = new CourseDaoImpl();
	
	private CourseDaoImpl() {
		courses = new Hashtable<String, Course>();
		courses.put("1", new Course("1", "JEE", "Cours Complet de JEE", 50.0f, true, "A" ,1));
		courses.put("2", new Course("2", "SPRING", "Module MVC et Data", 120f, false, "B", 2));
		courses.put("3", new Course("3", "GIT/GITHUB", "3 Hours", 33f, true, "E", 1));
		courses.put("4", new Course("4", "GL", "3 Hours", 200f ,true, "D", 4));
		courses.put("5", new Course("5", "MAVEN", "5 Hours", 20f , false , "C", 5));
		courses.put("6", new Course("6", "ORACLE", "10 Hours", 65f , true, "E", 4));
		courses.put("7", new Course("7", "XML", "10 Hours", 45f , false, "B", 3));
		courses.put("8", new Course("8", "REST", "3 Hours", 88f, true, "D", 5));
		courses.put("9", new Course("9", "JUnit", "5 Hours", 100f , false, "A", 2));
	}
	
	public static CourseDaoImpl getInstance() {
		return instance;
	}
	
	public int add(Course course) {
		if(course != null) {
			if(!courses.containsKey(course.getId())) {
				Course ord = course;
				courses.put(ord.getId(), ord);
				return 1;
			}
			return 0;
		}
		return 0;
	}

	public Course get(String id) {
		return courses.get(id);
	}
	
	public List<Course> getMatches(Course course){
		if(course != null && !course.emptyParameters()) {
			List<Course> foundCourses = null;
			{
				foundCourses = new Vector<Course>();
				for (Course c : courses.values()) {
					if(c.equals(course)) foundCourses.add(c);
				}
			}
			return foundCourses;
		}
		return null;
	}
}
