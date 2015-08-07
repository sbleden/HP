package de.db.base.model;

import java.util.Set;

public class Person {

	private String id;
	private String name;
	private int age;
	private Set<Interest> interests;
	private Set<Language> languages;

	public Person(String id) {
		this.id = id;
	}

	public Person(String id, String name) {
		this(id);
		this.name = name;
	}

	public Person(String id, String name, int age) {
		this(id, name);
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Interest> getInterests() {
		return interests;
	}

	public void addInterest(Interest interest) {
		this.interests.add(interest);
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void addLanguage(Language language) {
		this.languages.add(language);
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public String getId() {
		return id;
	}
}
