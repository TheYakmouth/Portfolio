package persistence2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String studentFirstName;
	private String studentLastName;
	private double GPA;
	private List<Student> studentList = new ArrayList<Student>();
	
	public Student() {}
	
	public Student(String lastNameIn, String firstNameIn, double gpaIn) {
		studentFirstName = firstNameIn;
		studentLastName = lastNameIn;
		GPA = gpaIn;
	}
	public String getFirstName() {
		return studentFirstName;
	}
	public String getLastName() {
		return studentLastName;
	}
	public void setFirstName(String fName) {
		this.studentFirstName = fName;
	}
	public void setLastName(String lName) {
		this.studentLastName = lName;
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
		if (otherStudent.studentFirstName.equals(studentFirstName) && otherStudent.studentLastName.equals(studentLastName) && otherStudent.GPA==(GPA))
			return true;
		return false;
	}
	
	public String toString() {
		return ("Student: "+studentLastName+", "+studentFirstName+"\nGPA: "+String.valueOf(GPA)+"\n");
	}

}
