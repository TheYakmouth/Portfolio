package persistence2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CoursePersister {
	public void saveCourses(File saveFile, Course c) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(saveFile)));
			out.writeObject(c);
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Course readCourseFile(File openFile) {
		ObjectInputStream in = null;
		Course c = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(openFile)));
			c = (Course) in.readObject();
			in.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}