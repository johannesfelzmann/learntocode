package java.ep2exam.test2_2_2020;

import java.util.Iterator;

// An iterator over all 'Orbitable' objects.
public interface OrbitIterator extends Iterator<Orbitable> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements.
    Orbitable next();

}