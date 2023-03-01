package piratepersister;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PirateBinaryPersister {
	public void savePirates(File saveFile, Pirate p) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(saveFile)));
			out.writeObject(p);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pirate readPirateFile(File openFile) {
		ObjectInputStream in = null;
		Pirate p = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(openFile)));
			p = (Pirate) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public void savePirateList(File saveListFile, List<Pirate> pirates) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(saveListFile)));
			out.writeObject(pirates);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<Pirate> readPirateList(File openListFile) {
		ObjectInputStream in = null;
		List<Pirate> pirates = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(openListFile)));
			pirates = (List<Pirate>) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pirates;
	}
}