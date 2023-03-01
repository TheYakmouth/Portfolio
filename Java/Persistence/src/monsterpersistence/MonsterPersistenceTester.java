package monsterpersistence;

import java.io.File;

public class MonsterPersistenceTester {
	public static void main(String[] args) {
		MonsterHerd mh1 = new MonsterHerd();
		mh1.addMonster(new Monster("Godzilla", "Tokyo", "crushes the power stations"));
		mh1.addMonster(new Monster("Bigfoot", "Seattle", "stomps around in the forest"));
		mh1.addMonster(new Monster("Jersey Devil", "Pine Barrens", "eats campers"));
		
		MonsterHerdPersister mp1 = new MonsterHerdPersister();
		File f = new File("f1.dat");
		mp1.saveHerdToFile(f, mh1);
		MonsterHerdPersister mp2 = new MonsterHerdPersister();
		MonsterHerd mh2 = mp2.readHerdFromFile(f);
		
		if (mh1.equals(mh2))
			System.out.println("Binary save and retrieve correct");
		else
			System.out.println("ERROR: Binary save and retrieve incorrect!");
		
		System.out.println("Herd 1: " + mh1);
		System.out.println("Herd 2: " + mh2);
	}
}