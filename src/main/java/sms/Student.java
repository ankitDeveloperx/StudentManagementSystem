package sms;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
	private int id;
	private String name;
	private String email;
	private int age;
	private String course;
	private String year;
	
	public Student() {
	}


	public Student(int id, String name, String email, int age, String course, String year) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.course = course;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", course=" + course
				+ ", year=" + year + "]";
	}

	
}