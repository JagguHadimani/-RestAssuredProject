package pojo;

public class GetCourse {
	private String url;
	private String services;
	private String expertise;
	private Courses Courses;
	//Since the Courses is a nested json, meaning it has array of objects, we will create another class to handle that. This class will go to the Courses.java file. 
	//We will create a class named Courses and then we will create an array of that class in the GetCourse class. We will also create getter and setter method for that array.
	private String instructor;
	private String LinkedIn;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public pojo.Courses getCourses() {
		return Courses;
	}

	public void setCourses(pojo.Courses courses) {
		Courses = courses;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getLinkedIn() {
		return LinkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}

}

//Since the Courses is a nested json, meaning it has array of objects, we will create another class to handle that.
//We will create a class named Courses and then we will create an array of that class in the GetCourse class.
//We will also create getter and setter method for that array.
