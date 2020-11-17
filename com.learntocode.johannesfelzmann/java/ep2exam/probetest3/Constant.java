package java.ep2exam.probetest3;

import java.util.*;

// 'Constant' implements 'Polynomial' and represents a polynomial with degree 0 corresponding
// to a constant value (regardless of the 'x' used for evaluation).
// 'Constant' is used by class 'HornerScheme'.
// The iterator of this class iterates over only one value and therefore behaves as follows:
// The 'next' method returns the constant value, if it is called for the first time.
// 'hasNext' is 'true' only if 'next' has not been called.
//
public class Constant implements Polynomial/* TODO: fix declaration. */ {

    //TODO: define missing parts of this class.
    private int constant;

    // Initializes this object.
    // Precondition: c != 0.
    public Constant(int c) {

        //TODO: implement constructor.
        this.constant = c;

    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public List<Integer> coefficients() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(this.constant);
        return list;
    }

    @Override
    public double eval(double x) {
        return this.constant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant integers = (Constant) o;
        return this.constant == integers.constant;
    }

    @Override
    public int hashCode() {
        return 7654321 * this.constant;
    }

    @Override
    public String toString() {
        return "" + this.constant;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private boolean first = true;

            @Override
            public boolean hasNext() {
                return first;
            }

            @Override
            public Integer next() {
                if(hasNext()){
                    first = false;
                    return constant;
                }

                throw new NoSuchElementException("no coefficient!");
            }
        };
    }
}


