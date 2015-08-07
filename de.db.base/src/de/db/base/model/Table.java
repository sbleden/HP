package de.db.base.model;

import java.util.LinkedList;
import java.util.List;

public class Table {

	private List<Chair> chairs = new LinkedList<>();

	public void addChair(Chair chair) {
		this.chairs.add(chair);
	}

	public List<Chair> getChairs() {
		return chairs;
	}

	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}

}
