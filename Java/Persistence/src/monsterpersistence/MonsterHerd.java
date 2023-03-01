package monsterpersistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MonsterHerd implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Monster> monsters = new ArrayList<Monster>();

	public List<Monster> getMonsters() {
		return monsters;
	}

	public void addMonster(Monster m) {
		monsters.add(m);
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null || other.getClass() != this.getClass())
			return false;
		MonsterHerd otherMH = (MonsterHerd) other;
		return equivLists(this.getMonsters(), otherMH.getMonsters());
	}

	public boolean equivLists(List<Monster> first, List<Monster> second) {
		if (first.size() != second.size())
			return false;
		for (int counter = 0; counter < first.size(); counter++)
			if (!(first.get(counter).equals(second.get(counter))))
				return false;
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Monster m : monsters)
			sb.append(m + "\n");
		return sb.toString();
	}
}