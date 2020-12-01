package ep2exam.probetest3;

import java.util.*;

// The class implements 'Polynomial' and represents the form (a + x*p), where 'a' is an Integer
// and 'p' is another polynomial. 'p' must not be 'null' (objects of 'Constant' shall be used to represent constants).
// This class implements 'Polynomial' by using Horner's scheme.
// Example:
// a₀ + a₁*x + a₂*x² + a₃*x³ + a₄*x⁴
// The polynomial above is represented in Horner's scheme as:
// a₀ + x*(a₁ + x*(a₂ + x*(a₃ + x*a₄)))
//
public class HornerScheme implements Polynomial/* TODO: fix declaration. */ {

    //TODO: define missing parts of this class.
    private int coeff;
    private Polynomial poly;

    // Initializes this object.
    // Precondition: 'p' must not be 'null'.
    public HornerScheme(int a, Polynomial p) {
        //TODO: implement this constructor.
        this.coeff = a;
        this.poly = p;
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        //TODO: implement this method.
        Polynomial p = new Constant(coeffs[coeffs.length-1]);

        for (int i = coeffs.length-2; i >= 0; i--) {
            p = new HornerScheme(coeffs[i], p);
        }

        return p;
    }

    @Override
    public int degree() {
        return this.coefficients().size()-1;
    }

    @Override
    public List<Integer> coefficients() {
        LinkedList<Integer> list = new LinkedList<>();
        for (Integer i : this) {
            list.add(i);
        }

        return list;
    }

    @Override
    public double eval(double x) {
        return this.coeff + x * this.poly.eval(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HornerScheme integers = (HornerScheme) o;
        return this.coeff == integers.coeff && this.poly.equals(integers.poly);
    }

    @Override
    public int hashCode() {
        return 7654321*this.coeff + this.poly.hashCode();
    }

    @Override
    public String toString() {
        return "(" + this.coeff + " + x*" + this.poly.toString() + ")";
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private Iterator iter = poly.iterator();
            private boolean first = true;

            @Override
            public boolean hasNext() {
                return iter.hasNext() || first;
            }

            @Override
            public Integer next() {
                if(hasNext()){
                    if(first){
                        first = false;
                        return coeff;
                    }else{
                        return (Integer) iter.next();
                    }
                }

                throw new NoSuchElementException("no coefficient!");
            }
        };
    }
}



