package persistence1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String studentName;
	private double GPA;
	private List<Student> studentList = new ArrayList<Student>();
	
	public Student() {}
	
	public Student(String nameIn, double gpaIn) {
		studentName = nameIn;
		GPA = gpaIn;
	}
	public String getName() {
		return studentName;
	}
	public void setName(String name) {
		this.studentName = name;
	}
	
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gpa) {
		this.GPA = gpa;
	}
	
	public void addStudent(Student s) {
		studentList.add(s);
	}
	public List<Student> getStudents(){
		return studentList;
	}
	
	@Override
	public	boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null || other.getClass() != this.getClass())
			return false;
		Student otherStudent = (Student) other;
		if (otherStudent.studentName.equals(studentName) && otherStudent.GPA==(GPA))
			return true;
		return false;
	}
	
	public String toString() {
		return ("Student: "+studentName+"\nGPA: "+String.valueOf(GPA));
	}

}
