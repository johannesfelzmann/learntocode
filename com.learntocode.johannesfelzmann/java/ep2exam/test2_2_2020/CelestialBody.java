package ep2exam.test2_2_2020;

// This class represents a single celestial body with no other objects in orbit.
// A celestial body has a name and a mass in kilograms.
//
// The iterator's 'hasNext' method always returns 'false'. The iteration has no elements.
//
// Adding another object into its orbit (method 'add') results in a 'CelestialSystem' with 'this'
// as central body.
//
public class CelestialBody implements Orbitable {

    private String name;
    private double mass;


    public CelestialBody(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Orbitable add(Orbitable inOrbit) {
        return new CelestialSystem(this, inOrbit);
    }

    @Override
    public OrbitIterator iterator() {
        return new OrbitIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Orbitable next() {
              return new CelestialBody(name, mass);
            }
        };
    }

    public double getMass() {
        return this.getMass();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.mass + " kg";
    }
}

