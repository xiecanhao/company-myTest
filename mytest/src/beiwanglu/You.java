package beiwanglu;

import java.util.ArrayList;
import java.util.List;

public class You {

	public static void main(String[] args) {
		List<Memento> savedTimes = new ArrayList<>();

		Life life = new Life();

		// time travel and record the eras
		life.set("2000 B.C.");
		savedTimes.add(life.saveToMemento());
		life.set("2000 A.D.");
		savedTimes.add(life.saveToMemento());
		life.set("3000 A.D.");
		savedTimes.add(life.saveToMemento());
		life.set("4000 A.D.");

		life.restoreFromMemento(savedTimes.get(0));

	}

}
