package ro.fasttrackit.curs3;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Java8Features {
    public static void main(String[] args) {
        lambdas();
        streams();
        optional();
        methodReferences();

    }

    private static void methodReferences() {
        names().stream()
                .map(String::length)
                .toList();
        names().stream()
                .map(String::valueOf)
                .toList();

        PersonManager personManager = new PersonManager();
        names().stream()
                .map(personManager::transform)
                .toList();
    }

    private static void optional() {
        System.out.println("==optional");
        Optional<String> myName = names().stream()
                .filter(name -> name.startsWith("W"))
                .findFirst()
                .map(String::toUpperCase)
                .map(Java8Features::abbreviate);

        if (myName.isPresent()) {
            System.out.println(myName.get());
        }

        System.out.println(myName.orElse(processDefault()));
        System.out.println(myName.orElseGet(() -> processDefault()));
        //MONAD
        String a = null;
        Optional<String> opt = Optional.of("test");
        if (a != null) {
            System.out.println(Optional.of(a));
        }
    }

    private static String processDefault() {
        System.out.println("CAlled processDefault");
        //processing
        return "processed";
    }

    private static void streams() {
        System.out.println("==== streams");
        System.out.println(names().stream()
                .filter(name -> name.length() < 13)
                .count());

        names().stream()
                .filter(name -> name.length() < 13)
                .peek(elem -> System.out.println(Thread.currentThread().getName()))
                .map(Java8Features::abbreviate)
                .forEach(System.out::println);

        class Counter {
            int count = 0;

            private void increment() {
                count++;
            }
        }

        Counter counter = new Counter();
        System.out.println("==parallel stream");
        IntStream.range(0, 1_000_000)
                .parallel()
                .mapToObj(index -> "index " + index)
                .peek(elem -> counter.increment())
                .map(a -> a + "test")
                .toList();

        boolean condition = names().stream()
                .anyMatch(name -> name.startsWith("A"));
//        names().parallelStream()
////                .filter(name -> name.length() < 13)
//                .peek(elem -> counter.increment())
//                .map(Java8Features::abbreviate)
//                .forEach(System.out::println);

        System.out.println(counter.count);
    }

    private static String abbreviate(String word) {
        return word.substring(0, word.indexOf(' ') + 2) + ".";
    }


    private static List<String> names() {
        return List.of("Isabell Bushman",
                "Wendolyn Roiger",
                "Magaret Demyan",
                "Corene Strang",
                "Marcie Fausnaught",
                "Valerie Maselli",
                "Terresa Ritenour",
                "Tamra Theiss",
                "Tyler Knicely",
                "Shenita Kerner",
                "Foster Keeney",
                "Nina Mulhall",
                "Reginia Peralto",
                "Daria Obando",
                "Sona Poff",
                "Gema Mink",
                "Delbert Kamp",
                "Tandra Wuensche",
                "Terrell Boelter",
                "Kyle Bassi");
    }

    private static void lambdas() {
        use(new MyInterface<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return input + 1;
            }
        });
        use(input -> input + 1);
    }

    private static void use(MyInterface<Integer, Integer> logic) {
        System.out.println(logic.apply(3));
    }
}

class Person {
    String name;

    void doSomething(Function<Integer, String> dos) {

    }
}

@FunctionalInterface
interface MyInterface<I, O> {
    O apply(I input);

    default void describe() {
        System.out.println("describing");
    }
}

