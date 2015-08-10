// package de.db.base.testscene1;
//
// import java.util.Arrays;
// import java.util.HashSet;
// import java.util.Set;
//
// import com.google.common.collect.Sets;
//
// import de.db.base.model.CorrelationProvider;
// import de.db.base.model.Person;
// import de.db.base.model.interfaces.IPersonProvider;
// import de.db.base.solving.provider.IPersonWeigthDeterminer;
// import de.db.base.solving.provider.SimpleWeightDeterminer;
//
// public class Scene1 {
//
// private Set<Person> persons = new HashSet<>();
// private CorrelationProvider correlationProvider;
//
// private int idCounter = 0;
//
// public Scene1() {
// correlationProvider = new CorrelationProvider();
// build();
// }
//
// protected void build() {
// // Pair
// Person jeremy = createPerson("Jeremy");
// Person Jaqueline = createPerson("Jaqueline");
// correlationProvider.addCorrelation(jeremy, Jaqueline, 10);
//
// Person kaiUwe = createPerson("Kai Uwe");
// cartesian(10, jeremy, Jaqueline, kaiUwe);
//
// Person peggy = createPerson("Peggy");
// Person amanda = createPerson("amanda");
// correlationProvider.addCorrelation(jeremy, peggy, 8);
// correlationProvider.addCorrelation(amanda, peggy, 10);
// correlationProvider.addCorrelation(amanda, jeremy, 6);
// correlationProvider.addCorrelation(amanda, Jaqueline, 0);
//
// Person ruediger = createPerson("amanda");
// correlationProvider.addCorrelation(amanda, ruediger, 10);
// correlationProvider.addCorrelation(jeremy, ruediger, 1);
//
// Person manuela = createPerson("Manuela");
// Person heinzEbert = createPerson("Heinz Ebert");
// correlationProvider.addCorrelation(manuela, heinzEbert, 10);
// correlationProvider.addCorrelation(jeremy, heinzEbert, 7);
// correlationProvider.addCorrelation(jeremy, manuela, 7);
//
// Person claudia = createPerson("Claudia");
// Person stefan = createPerson("Stefan");
// correlationProvider.addCorrelation(claudia, stefan, 2);
//
// Person Sylvie = createPerson("Sylvie");
// Person Rafael = createPerson("Rafael");
// correlationProvider.addCorrelation(Sylvie, Rafael, 10);
// correlationProvider.addCorrelation(manuela, Sylvie, 1);
// correlationProvider.addCorrelation(manuela, Rafael, 1);
//
// Person mandy = createPerson("Mandy");
// Person oliver = createPerson("Oliver");
// Person karlAnton = createPerson("karlAnton");
// Person karlUdo = createPerson("karlUdo");
// Person karlPaul = createPerson("karlPaul");
// Person karlPhillip = createPerson("karlPhillip");
// cartesian(9, mandy, oliver, karlAnton, karlUdo, karlPaul, karlPhillip);
// correlationProvider.addCorrelation(jeremy, oliver, 0);
//
// Person jennifer = createPerson("jennifer");
// Person marcel = createPerson("marcel");
// correlationProvider.addCorrelation(jennifer, manuela, 1);
// cartesian(10, jennifer, marcel, jeremy);
//
// Person michel = createPerson("michel");
// correlationProvider.addCorrelation(Jaqueline, michel, 0);
// correlationProvider.addCorrelation(jeremy, michel, 10);
//
// Person frederico = createPerson("Frederico");
//
// Person svenja = createPerson("Svenja");
// Person matthieu = createPerson("Matthieu");
// correlationProvider.addCorrelation(svenja, matthieu, 10);
//
// Person andrew = createPerson("Andrew");
// Person lunaTiger = createPerson("Luna Tiger");
// correlationProvider.addCorrelation(andrew, lunaTiger, 10);
//
// Person emily = createPerson("Emily");
// Person pascal = createPerson("Pascal");
// correlationProvider.addCorrelation(emily, pascal, 10);
//
// correlationProvider.addCorrelation(frederico, matthieu, 1);
// correlationProvider.addCorrelation(frederico, svenja, 8);
//
// cartesian(2, Sets.newHashSet(andrew, lunaTiger), Sets.newHashSet(pascal,
// emily));
// cartesian(2, Sets.newHashSet(andrew, lunaTiger), Sets.newHashSet(matthieu,
// svenja));
// cartesian(2, Sets.newHashSet(matthieu, svenja), Sets.newHashSet(pascal,
// emily));
// }
//
// private void cartesian(int weigth, Set<Person> p1, Set<Person> p2) {
// Sets.cartesianProduct(p1, p2).stream()
// .forEach(pair -> correlationProvider.addCorrelation(pair.get(0), pair.get(1),
// weigth));
// }
//
// private void cartesian(int weigth, Person... persons) {
// Set<Person> ps = new HashSet<>(Arrays.asList(persons));
// cartesian(weigth, ps, ps);
// }
//
// private Person createPerson(String name) {
// return createPerson(name, 18);
// }
//
// private Person createPerson(String name, int age) {
// Person person = new Person(idCounter++, name, age);
// persons.add(person);
// return person;
// }
//
// public Set<Person> getPersons() {
// return persons;
// }
//
// public IPersonProvider getPersonProvider() {
// return this::getPersons;
// }
//
// public IPersonWeigthDeterminer getWeigthDeterminer() {
// return new SimpleWeightDeterminer(correlationProvider);
// }
//
// }
