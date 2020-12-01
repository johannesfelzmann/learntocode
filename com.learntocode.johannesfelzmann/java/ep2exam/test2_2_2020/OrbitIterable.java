package ep2exam.test2_2_2020;

public interface OrbitIterable extends Iterable<Orbitable> {

    // Returns an iterator over 'Orbitable' objects.
    OrbitIterator iterator();

}
