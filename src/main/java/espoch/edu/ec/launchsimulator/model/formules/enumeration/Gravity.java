package espoch.edu.ec.launchsimulator.model.formules.enumeration;

public enum Gravity {
    MERCURY(3.70f),
    VENUS(8.87f),
    EARTH(9.8f),
    MARS(3.71f),
    JUPITER(24.79f),
    SATURN(10.44f),
    URANUS(8.87f),
    NEPTUNE(11.15f),
    PLUTO(0.62f);

    private final Float planets;

    private Gravity(Float planets) {
        this.planets = planets;
    }

    public Float getPlanets() {
        return planets;
    }

}
