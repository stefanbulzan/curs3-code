package ro.fasttrackit.homework;

import java.util.Optional;
import java.util.stream.Stream;

interface Transformable {
    double getMass(int initial);
}

public enum CelestialBody implements Transformable {
    TERRA(1) {
        @Override
        public int getPositionInSolarSystem(String test) {
            return 3;
        }
    },
    MERCURY(1.4) {
        @Override
        public String getDescription() {
            return "mercury description";
        }

        @Override
        public int getPositionInSolarSystem(String test) {
            return 1;
        }
    },
    VENUS(2) {
        @Override
        public int getPositionInSolarSystem(String test) {
            return 2;
        }
    };

    private final double ratio;

    CelestialBody(double ratio) {
        this.ratio = ratio;
    }

    public String getDescription() {
        return "generic description";
    }

    @Override
    public double getMass(int initial) {
        return initial * ratio;
    }

    public abstract int getPositionInSolarSystem(String test);

    public static Optional<CelestialBody> of(String value) {
        return Stream.of(values())
                .filter(enumValue -> enumValue.name().equalsIgnoreCase(value))
                .findFirst();
    }
}

class CelestialBodyClass {
    public final static CelestialBodyClass TERRA = new CelestialBodyClass(1){
        @Override
        public String getDescription() {
            return "terra";
        }
    };
    public final static CelestialBodyClass MERCURY = new CelestialBodyClass(1.4);
    public final static CelestialBodyClass VENUS = new CelestialBodyClass(2);

    private final double ratio;


    CelestialBodyClass(double ratio) {
        this.ratio = ratio;
    }

    public String getDescription(){
        return "generic";
    }
}
