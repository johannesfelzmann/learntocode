package ep2exam.test2_2_2020;


import java.util.LinkedList;
import java.util.NoSuchElementException;

// A celestial system implements 'Orbitable' and has at least one object in orbit around its
// central celestial body. Further objects can be added.
//
public class CelestialSystem implements Orbitable {

    private CelestialBody centralBody;
    private LinkedList<Orbitable> list;

    // Initialises this system with its central body.
    public CelestialSystem(CelestialBody centralBody, Orbitable inOrbit) {
       this.centralBody = centralBody;
       list = new LinkedList<>();
       list.add(inOrbit);
    }

    @Override
    public String getName() {
        return this.centralBody.getName();
    }

    @Override
    public Orbitable add(Orbitable inOrbit) {
        CelestialSystem r = new CelestialSystem(centralBody, inOrbit);
        r.list.addAll(this.list);
        return (Orbitable) r;
    }

    @Override
    public OrbitIterator iterator() {
        return new OrbitIterator() {

            int i = list.size()-1;

            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public Orbitable next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                Orbitable r = list.get(i);
                i--;
                return r;
            }
        };
    }

    @Override
    public String toString() {
        String retVal = centralBody.toString();

        OrbitIterator o = this.iterator();

        while(o.hasNext()){
            retVal += "\n   " + o.next().toString();
        }

        return retVal;
    }
}

