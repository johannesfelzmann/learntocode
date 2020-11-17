package java.ep2exam.test2_1_2020;

public interface MobileIterable extends Iterable<Star> {

    // Returns an iterator over all leaf nodes ('Star' objects) of the mobile.
    MobileIterator iterator();

}
