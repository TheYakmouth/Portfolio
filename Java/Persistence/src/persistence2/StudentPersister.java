package persistence2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentPersister {
	public void saveStudents(File saveFile, Student s) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(saveFile)));
			out.writeObject(s);
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Student readStudentFile(File openFile) {
		ObjectInputStream in = null;
		Student s = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(openFile)));
			s = (Student) in.readObject();
			in.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
