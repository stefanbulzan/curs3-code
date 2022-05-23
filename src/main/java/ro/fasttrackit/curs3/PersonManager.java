package ro.fasttrackit.curs3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class PersonManager {
    private static List<String> persons = new ArrayList<>(List.of("Dan", "Cornel"));

    public static void main(String[] args) {
        String dan = "Dan";
        AlexSupplier param = new AlexSupplier();

        String alex = persons.stream()
                .filter(name -> name.equalsIgnoreCase(dan))
                .findFirst()
                .orElseGet(() -> addPerson(dan));

        System.out.println(alex);
        System.out.println(persons);
    }

    static class AlexSupplier implements Supplier<String> {
        @Override
        public String get() {
            return addPerson("Dan");
        }
    }

    private static String addPerson(String person) {
        System.out.println("added dan");
        persons.add(person);
        return person;
    }

    public  String transform(String person) {
        return person.toUpperCase();
    }
}
