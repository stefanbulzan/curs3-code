package ro.fasttrackit.curs3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class PersonRepository {
    private final List<String> persons = new ArrayList<>();

    public String findByCity(String city) {
        String myCity = ofNullable(city)
//                .orElse("Oradea");
                .orElseThrow(() -> new IllegalArgumentException("City cannot be null"));
        return myCity;
    }

    public Optional<String> findByName(String name) {
        for (String person : persons) {
            if (person.equalsIgnoreCase(name)) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        Optional<String> person = repo.findByName("Dan");
        if (person.isPresent()) {

        }
        String a = null;
        repo.findByCity(a);


    }
}
