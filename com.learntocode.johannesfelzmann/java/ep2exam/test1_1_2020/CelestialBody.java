package java.ep2exam.test1_1_2020;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class CelestialBody {

    private String name;
    private double mass;

    // Initializes 'this' with name and mass.
    // Precondition: name != null.
    public CelestialBody(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public int compareTo(CelestialBody body) {
        return this.name.compareTo(body.name);
    }

    public String toString() {
        return this.name + ": " + this.mass;
    }

}

