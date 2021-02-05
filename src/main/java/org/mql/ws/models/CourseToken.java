package org.mql.ws.models;

public class CourseToken {
	
	private String token;
	private Course course;
	
	public CourseToken(String token, Course course) {
		super();
		this.token = token;
		this.course = course;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
}