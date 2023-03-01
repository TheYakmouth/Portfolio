package persistence1;

import java.io.File;

public class PersistenceDriver {
	public static void main(String args[]) {
		Student studentList = new Student();
		Course courseList = new Course();
		
		Course c1 = new Course("Comp Sci");
		Course c2 = new Course("English");
		
		Student s1 = new Student("Josh", 3.50);
		c1.addStudent(s1); studentList.addStudent(s1);
		Student s2 = new Student("Abby", 3.95);
		c1.addStudent(s2); studentList.addStudent(s2);
		Student s3 = new Student("Barry", 3.06);
		c2.addStudent(s3); studentList.addStudent(s3);
		
		courseList.addCourse(c1);
		courseList.addCourse(c2);
		
		StudentPersister sp1 = new StudentPersister();
		File studentFile = new File("students.dat");
		sp1.saveStudents(studentFile, studentList);
		StudentPersister sp2 = new StudentPersister();
		Student sListIn = sp2.readStudentFile(studentFile);
		
		CoursePersister cs1 = new CoursePersister();
		File courseFile = new File("courses.dat");
		cs1.saveCourses(courseFile, courseList);
		CoursePersister cs2 = new CoursePersister();
		Course cListIn = cs2.readCourseFile(courseFile);
		
		if (courseList.getCourses().equals(cListIn.getCourses()))
			System.out.println("Binary save and retrieve correct");
		else
			System.out.println("ERROR: Binary save and retrieve incorrect!");
		
		System.out.println(sListIn.getStudents());
		System.out.println(cListIn.getStudents());
		//System.out.println(cListIn.getCourses());
		
		//System.out.println(courseList.getCourses());
		//System.out.println(studentList.getStudents());
		
	}

}
