package ep2exam.test2_1_2020;

import java.util.Iterator;

public interface MobileIterator extends Iterator<Star> {
    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements.
    Star next();
}
