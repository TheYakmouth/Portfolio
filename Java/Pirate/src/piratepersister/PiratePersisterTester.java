package piratepersister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PiratePersisterTester {

	public static void main(String[] args) {
		List<Pirate> pirates = new ArrayList<Pirate>();

		Pirate blackBeard = new Pirate("BlackBeard", 20);
		Pirate blueBeard = new Pirate("Bluebeard", 15);
		Pirate stedeBonnet = new Pirate("Stede Bonnet", 12);
		Pirate jackSparrow = new Pirate("Jack Sparrow", 33);

		pirates.add(blackBeard);
		pirates.add(blueBeard);
		pirates.add(stedeBonnet);

		PirateBinaryPersister pb1 = new PirateBinaryPersister();
		File pirateFile = new File("pirateFile.dat");
		pb1.savePirates(pirateFile, jackSparrow);

		PirateBinaryPersister pb2 = new PirateBinaryPersister();
		Pirate pirateIn = pb2.readPirateFile(pirateFile);
		System.out.println(pirateIn);

		if (jackSparrow.getName().equals(pirateIn.getName()) && jackSparrow.getRum() == (pirateIn.getRum()))
			System.out.println("Binary save and retrieve correct");
		else
			System.out.println("ERROR: Binary save and retrieve incorrect!");

		PirateBinaryPersister list = new PirateBinaryPersister();
		File pirateListFile = new File("pirateList.dat");
		list.savePirateList(pirateListFile, pirates);

		PirateBinaryPersister listReader = new PirateBinaryPersister();
		List<Pirate> pirateListIn = listReader.readPirateList(pirateListFile);
		System.out.println(pirateListIn);

		for (Pirate p : pirateListIn) {
			if (p.getName().equals(p.getName()) && p.getRum() == (p.getRum()))
				System.out.println("Binary save and retrieve correct");
			else
				System.out.println("ERROR: Binary save and retrieve incorrect!");
		}

	}

}
