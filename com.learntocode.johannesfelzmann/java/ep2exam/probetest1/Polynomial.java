package ep2exam.probetest1;

// This class represents a polynomial. A polynomial is a sum of multiple monomials (class 'Monomial'),
// such as 3*x^1 + -1*x^2 + 1*x^5.
// 'Polynomial' uses a binary search tree to store its monomials. The degree of the monomial is the key.
// A specific degree exists at most once in the polynomial.
// TODO: define further classes for the implementation of the binary search tree, if needed


public class Polynomial {

    //TODO: declare variables
    TreePNode root;

    // Initializes this polynomial with multiple monomials. The coefficients of the monomials are
    // specified by 'coeffs', where coeffs[i] is the coefficient of the monomial of degree i.
    // Entries with value 0 are ignored, i.e. corresponding monomials are not stored in the polynomial.
    public Polynomial(int[] coeffs) {
        // TODO: implement this constructor
        for (int i = 0; i < coeffs.length; i++) {
            if(coeffs[i] != 0){
                if(root == null){
                    root = new TreePNode(new Monomial(coeffs[i], i));
                }else{
                    root.add(new Monomial(coeffs[i], i));
                }
            }
        }
    }

    // Adds the monomial specified by 'coeff' and 'degree' to this polynomial, if coeff != 0,
    // otherwise 'add' has no effect.
    // If this polynomial already has a monomial of the same degree, no new monomial is added, instead
    // the coefficient of the monomial is modified accordingly ('combine' is called).
    public void add(int coeff, int degree) {
        // TODO: implement this method
        root.add(new Monomial(coeff, degree));
    }

    // Adds all monomials of 'p' to this polynomial.
    // (The rules of 'add(int,int)' apply for each monomial to be added.)
    public void add(Polynomial p) {
        // TODO: implement this method
        p.root.addAll(root);
    }

    // Returns the value of the polynomial for a specified value of 'x'
    public int eval(int x) {
        // TODO: implement this method
        return root.eval(x);
    }

    // Returns a polynomial representation in mathematical notation such as
    // "2*x^0 + 6*x^2 + -2*x^3", where monomials are ordered ascending according to
    // their degree. Note that a positive sign of the leftmost coefficient is
    // not shown.
    // Returns the string "0" if the polynomial has no monomials (is empty).
    public String toString() {
        // TODO: implement this method
        return root.toString();
    }

}

class TreePNode{
    private Monomial value;
    private TreePNode left, right;

    public TreePNode(Monomial m){
        this.value = m;
    }


    public void add(Monomial m) {

        if(m.lowerDegreeThan(value)){
            if(left == null){
                left = new TreePNode(m);
            }else{
                left.add(m);
            }
        }else if(value.lowerDegreeThan(m)){
            if(right == null){
                right = new TreePNode(m);
            }else{
                right.add(m);
            }
        }else{
            value.combine(m);
        }

    }

    @Override
    public String toString() {
        if(left == null && right == null){
            return value.toString();
        }

        String retVal = this.value.toString();
        if(left != null){
            retVal = left.toString() + " + " + retVal;
        }
        if(right != null){
            retVal = retVal + " + " + right.toString();
        }

        return retVal;
    }

    public int eval(int x) {

        int retVal = this.value.eval(x);

        if(left != null){
            retVal += left.eval(x);
        }
        if(right != null){
            retVal += right.eval(x);
        }

        return retVal;
    }

    public void addAll(TreePNode r) {

        r.add(value);

        if(left != null){
            left.addAll(r);
        }

        if(right != null){
            right.addAll(r);
        }
    }
}

