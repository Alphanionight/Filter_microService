package org.mql.ws.models;

public class Course {
	private String id;
	private String name;
	private String description;
	private float price;
	private boolean isCertified;
	private String category;
	private int level;
	
	public Course() {}

	public Course(String id, String name, String description, float price, boolean isCertified, String category,
			int level) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isCertified = isCertified;
		this.category = category;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isCertified() {
		return isCertified;
	}

	public void setCertified(boolean isCertified) {
		this.isCertified = isCertified;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	//filter methode
	
	public boolean emptyParameters() {
		if(
			id == null && 
			name == null &&
			description == null &&
			price == 0 &&
			category == null &&
			level == 0 &&
			isCertified == false
		) return true;
		return false;
	}
	
	public boolean equals(Course course) {
		if(course.getId() != null) {
			if(!course.getId().trim().toUpperCase().equals(this.id)) return false;
		}
		if(course.getName() != null) {
			if(!course.getName().trim().toUpperCase().equals(this.name)) return false;
		}
		if(course.getDescription() != null) {
			if(!course.getDescription().trim().toUpperCase().equals(this.description)) return false;
		}
		if(course.getPrice() != null) {
			if(!course.getPrice().equals(this.price)) return false;
		}
		if(course.getCategory() != null) {
			if(!course.getCategory().trim().toUpperCase().equals(this.category)) return false;
		}
		if(course.isCertified() != this.isCertified) return false;
		if(course.getId() != null) {
			if(course.getId() != this.id) return false;
		}
		return true;
	}
}
