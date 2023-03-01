package monsters;

import java.util.Scanner;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AttackMonitor {
	
	static List<MonsterAttack> monsterList = new ArrayList<MonsterAttack>();
	static Scanner input = new Scanner(System.in);
	
	public void reportAttacks() {
		MonsterAttack inputAttack = new MonsterAttack();
		System.out.println("Enter Name, Location, Damage, and Date");
		
		inputAttack.setMonsterName(input.next());
		inputAttack.setLocation(input.next());
		inputAttack.setDamage(input.nextDouble());
		inputAttack.setDate(input.next());
			
		MonsterAttack reportAttack = new MonsterAttack(inputAttack.getMonsterName(), inputAttack.getLocation(), 
					inputAttack.getDamage(), inputAttack.getDate());
			
		monsterList.add(reportAttack);
	}
	
	public void showAttacks() {
		for (MonsterAttack m: monsterList) {
			System.out.println(m.toString());
		}
	}
	
	public void showDamages() {
		double totalDamage = 0;
		double meanDamage = 0;
		for (MonsterAttack a: monsterList) {
			totalDamage += a.getDamage();
		}
		meanDamage = totalDamage/(monsterList.size());
		
		System.out.printf("Total Damage in Millions: $%.3f %n", totalDamage);
		System.out.printf("Average Damage per Monster: $%.3f %n", meanDamage);
	}
	
	public void showMonsters() {
		String temp = "";
		for (MonsterAttack m: monsterList) {
			String currentMonster = m.getMonsterName();
			int counter = 0;
			for (MonsterAttack n: monsterList) {
				if (currentMonster.equals(n.getMonsterName()))
					counter++;
			}
			if (!currentMonster.equals(temp))
				System.out.println(currentMonster + ": " + counter + " attack(s)");
			if (counter > 1)
				temp = currentMonster;
		}		
	}
		
	public void findEarliestattack() {
		int temp = 3000;
		String earliestDate = "";
		for (MonsterAttack m: monsterList) {
			String attackDate = m.getDate();
			int lastFour = Integer.parseInt(attackDate.substring(6));
			if (lastFour < temp) {
				temp = lastFour;
				earliestDate = attackDate;
			}
		}
		System.out.println(earliestDate);
	}
	
	public void readFile() {
		monsterList.clear();
		try {
			System.out.println("Enter File Path: ");
			MonsterAttack file = new MonsterAttack();
			File readFile = new File(input.next());
			Scanner fileReader = new Scanner(readFile);
			String[] fields;
			String line;
			fileReader.nextLine();
		
			while (fileReader.hasNextLine()) {
				line = fileReader.nextLine();
				fields = line.split(",");
				file.setMonsterName(fields[0]);
				file.setLocation(fields[1]);
				file.setDamage(Double.parseDouble(fields[2]));
				file.setDate(fields[3]);
			
				MonsterAttack fileAttack = new MonsterAttack(file.getMonsterName(), file.getLocation(), file.getDamage(), file.getDate());
				monsterList.add(fileAttack);
			}

		fileReader.close();
		}
		catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
	
	public void saveFile() {
		System.out.println("Enter File Path to Save to: ");
		File outFile = new File(input.next());
		try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			 
			 writer.append("Monster Name");
			 writer.append(",");
			 writer.append("Attack Location");
			 writer.append(",");
			 writer.append("Damage");
			 writer.append(",");
			 writer.append("Date (MM/DD/YYYY)");
			 writer.newLine();

			 for (MonsterAttack m : monsterList) {
				writer.append(m.getMonsterName());
				writer.append(",");
				writer.append(m.getLocation());
				writer.append(",");
				writer.append(Double.toString(m.getDamage()));
				writer.append(",");
				writer.append(m.getDate());
				writer.newLine();
			 }
			 writer.close();
		}	 
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
	
	public void menu() {
		AttackMonitor run = new AttackMonitor();
		boolean quit = false;
		while (!quit) {
			System.out.print("Enter number to run program: ");
			int userChoice = input.nextInt();
			switch(userChoice) {
				case 1 : run.reportAttacks(); 
					break;
				case 2 : run.showAttacks();
					break;
				case 3 : run.showDamages();
					break;
				case 4 : run.showMonsters();
					break;
				case 5 : run.findEarliestattack();
					break;
				case 6 : run.saveFile();
					break;
				case 7 : run.readFile();
					break;
				case 0 : System.out.println("Exiting Program");
				quit = true;
					return;
				default : System.out.println("Invalid Input");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		AttackMonitor a = new AttackMonitor();
		
		System.out.printf("1.) Report an Attack %n"
				+ "2.) Show Current Series of Attacks %n"
				+ "3.) Show a Damage Report %n"
				+ "4.) Show Current Monsters and Attack Count %n"
				+ "5.) Show Earliest Attack %n"
				+ "6.) Save File %n"
				+ "7.) Open File %n"
				+ "Enter Zero to Exit Program %n");
		
		a.menu();
	}
	
}
/*
F:\Java_files\MonsterList.csv
F:\Java_files\test.csv
Godzilla Tokyo 123.45 08/27/1954
Yeti Kathmandu 6.5 05/15/1964
Bigfoot Detroit 3.2 02/28/1988
Chubacabra Mazatlán 12.8 06/09/1991
Megaladon London 56.98 06/29/2002
*/