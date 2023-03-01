package persistence1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	private String courseName;
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public Course() {}
	
	public Course(String nameIn) {
		courseName = nameIn;
	}
	public void addCourse(Course c) {
		courses.add(c);
	}
	public List<Course> getCourses(){
		return courses;
	}
	
	public List<Student> getStudents(){
		return students;
	}
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String cName) {
		this.courseName = cName;
	}
	
	@Override
	public	boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null || other.getClass() != this.getClass())
			return false;
		Course otherCourse = (Course) other;
		if (otherCourse.courseName.equals(courseName) && otherCourse.students.equals(students))
			return true;
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Student s : students)
			sb.append(s + "\n");
		return ("Course: "+courseName+"\n"+sb);
	}

}
