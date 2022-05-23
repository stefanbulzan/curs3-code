package ro.fasttrackit.homework;

import static ro.fasttrackit.homework.CelestialBody.MERCURY;
import static ro.fasttrackit.homework.CelestialBody.TERRA;

public class CelestialMain {
    public static void main(String[] args) {
        System.out.println(TERRA.getPositionInSolarSystem("input"));
        System.out.println(MERCURY.getDescription());
        CelestialBody terraEnum = CelestialBody.of("MERCURY").orElse(TERRA);
        System.out.println(terraEnum);


        System.out.println(CelestialBodyClass.TERRA.getClass());
        System.out.println(CelestialBodyClass.MERCURY.getClass());
    }
}
