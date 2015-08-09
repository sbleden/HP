package de.db.base.solving;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import com.google.common.collect.Iterables;

import de.db.base.model.Person;
import de.db.base.model.Table;
import de.db.base.solving.interfaces.IConnectionDescription;
import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.interfaces.ISolvingResult;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;

public class ShuffleSolver implements ISolver {

	protected IPersonProvider personProvider;
	protected IPersonWeigthDeterminer personWeigthDeterminer;
	protected IRoomDescriptor roomDescriptor;
	private int runs;

	public ShuffleSolver(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer,
			IRoomDescriptor roomDescriptor, int runs) {
		super();
		this.personProvider = personProvider;
		this.personWeigthDeterminer = personWeigthDeterminer;
		this.roomDescriptor = roomDescriptor;
		this.runs = runs;
	}

	@Override
	public ISolvingResult calculate() throws InvalidInputException {
		SimpleSolvingResult bestResult = null;
		int bestWeigth = 0;
		for (int i = 0; i < runs; i++) {
			SimpleSolvingResult tempresult = createRandomResult();
			int tempWeigth = evaluate(tempresult);
			if (bestResult == null || tempWeigth > bestWeigth) {
				bestResult = tempresult;
				bestWeigth = tempWeigth;
			}
		}
		bestResult.setWeigth(bestWeigth);
		return bestResult;
	}

	private SimpleSolvingResult createRandomResult() throws InvalidInputException {
		Hashtable<Person, Table> mapping = new Hashtable<>();
		Set<Table> fullTables = new HashSet<>();
		Set<Table> nonFullTables = new HashSet<>();
		roomDescriptor.getTables().forEach(td -> nonFullTables.add(new Table(td)));
		Set<Person> persons = personProvider.getPersons();
		for (Person person : persons) {
			if (nonFullTables.isEmpty()) {
				throw new InvalidInputException();
			}
			Table freeTable = Iterables.get(nonFullTables, ((int) (Math.random() * nonFullTables.size())));
			freeTable.addPerson(person);
			mapping.put(person, freeTable);
			if (freeTable.isFull()) {
				fullTables.add(freeTable);
				nonFullTables.remove(freeTable);
			}
		}
		return new SimpleSolvingResult(mapping);
	}

	private int evaluate(SimpleSolvingResult result) {
		int weigth = 0;
		for (Person p1 : personProvider.getPersons()) {
			for (Person p2 : personProvider.getPersons()) {
				if (!p1.equals(p2)) {
					weigth += personWeigthDeterminer.weigth(new IConnectionDescription() {

						@Override
						public boolean isNeighbourTable() {
							return roomDescriptor.isNeighbourTable(result.get(p1).getTableDescription(),
									result.get(p2).getTableDescription());
						}

						@Override
						public boolean equalTables() {
							return result.get(p1).equals(result.get(p2));
						}
					}, p1, p2);
				}
			}
		}
		return weigth;
	}

}
