package java.ep2exam.probetest1;

// This class represents monomials of the form a*x^d ("a mal x hoch d"), where
// 'a' is the coefficient of the monomial and 'd' is the degree.
public class Monomial {

    //TODO: declare variables
    private int coeff;
    private int degree;

    // A constructor with the coefficient 'coeff' and the 'degree' of this monomial.
    public Monomial(int coeff, int degree) {
        // TODO: implement this constructor
        this.coeff = coeff;
        this.degree = degree;
    }

    // Copy-constructor: uses 'coeff' and 'degree' of 'm' to initialize this monomial.
    public Monomial(Monomial m) {
        // TODO: implement this constructor
        this.coeff = m.coeff;
        this.degree = m.degree;
    }

    // Adds the monomial 'm' to this monomial, if both monomials have the same degree.
    // In this case this monomial's coefficient is replaced by the sum of this monomial's
    // coefficient and the coefficient of 'm'. In this case the method returns 'true'.
    // If 'm' has not the same degree as 'this', the method has no effect and
    // returns 'false'.
    public boolean combine(Monomial m) {
        // TODO: implement this method
        if(this.degree == m.degree){
            this.coeff += m.coeff;
            return true;
        }
        return false;
    }

    // Returns 'true' if 'm' has a higher degree than 'this', and 'false' otherwise.
    public boolean lowerDegreeThan(Monomial m) {
        // TODO: implement this method
        return m.degree > this.degree;
    }

    // Returns the value of the monomial for a specified value of 'x'
    public int eval(int x) {
        // TODO: implement this method
        return (int) (this.coeff * Math.pow(x,this.degree));
    }


    // Returns a representation in mathematical notation, e.g. of the form "5*x^2".
    public String toString() {
        // TODO: implement this method
        return "" + this.coeff + "*x^" + this.degree;
    }


}




