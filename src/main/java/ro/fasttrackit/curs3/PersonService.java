package ro.fasttrackit.curs3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

record Student(String name, int age) {
}

public class PersonService {
    private static final List<Student> students = new ArrayList<>(List.of(
            new Student("Dan", 22),
            new Student("Maria", 22),
            new Student("Ion", 26),
            new Student("Mihai", 32)
    ));

    public static void main(String[] args) {
        Map<Integer, List<Student>> collect = students.stream()
                .collect(groupingBy(PersonService::myGroupingLogic));
        System.out.println(collect);

        Map<Integer, List<String>> groupNames = students.stream()
                .collect(groupingBy(Student::age, mapping(Student::name, toList())));
        System.out.println(groupNames);
    }

    private static Integer myGroupingLogic(Student student) {
        return student.age();
    }
}
