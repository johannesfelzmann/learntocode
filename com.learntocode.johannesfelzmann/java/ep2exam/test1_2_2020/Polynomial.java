package java.ep2exam.test1_2_2020;

// A polynomial is a sum of multiple monomials , such as 3*x^1 + -1*x^2 + 1*x^5.
// 'Polynomial' uses a sorted linked list to store its monomials.
// A specific degree exists at most once in the polynomial.

public class Polynomial {

    private ListNode head;

    public Polynomial(){}

    // Adds the monomial 'm' to this polynomial.
    // If the polynomial already has a monomial of the same degree, the corresponding monomial
    // is replaced by its sum with 'm' (which is a new Monomial of the same degree and a
    // coefficient corresponding to the sum of the coefficients).
    public void add(Monomial m) {

        //base case
        if(head == null){
            head  = new ListNode(m);
        }else{
            //degree <, degree >, degree same

            ListNode mNode = new ListNode(m);
            boolean changed = false;
            ListNode currPrev = head;
            ListNode curr = head;
            while(curr != null){

                if(m.getDegree() < curr.value().getDegree()){

                    if(curr != head){
                        curr.prev().setNext(mNode);
                        mNode.setPrev(curr.prev());
                        curr.setPrev(mNode);
                        mNode.setNext(curr);
                    }else{
                        ListNode help = head;
                        head = mNode;
                        head.setNext(help);
                        head.next().setPrev(head);
                    }

                    changed = true;
                    break;
                }else if(curr.value().getDegree() == m.getDegree()){


                    Monomial newM = new Monomial(curr.value().getCoeff() + m.getCoeff(), m.getDegree());
                    curr.setValue(newM);
                    changed = true;
                    break;
                }

                currPrev = curr;
                curr = curr.next();
            }

            if(!changed){
                curr = mNode;
                currPrev.setNext(curr);
                curr.setPrev(currPrev);
            }


        }

    }

    // Returns a new polynomial which is the product of 'this' and 'm', i.e. in which
    // each monomial of 'this' has been multiplied by 'm'. Calling this method does not
    // affect 'this'.
    public Polynomial mult(Monomial m) {

        ListNode curr = head;
        Polynomial p = new Polynomial();

        while(curr != null){

            p.add(curr.value().mult(m));

            curr = curr.next();
        }

        return p;
    }

    // Returns a polynomial representation in mathematical notation such as
    // "2*x^0 + 6*x^2 + -2*x^3", where monomials are ordered ascending according to
    // their degree. Note that a positive sign of the leftmost coefficient is
    // not shown.
    // Returns the string "0" if the polynomial has no monomials (is empty).
    public String toString() {

        if(head == null){
            return "0";
        }

        ListNode curr = head;
        String retVal = "";

        while(curr != null){

            if(curr == head){
                retVal += curr.value().toString();
            }else{
                retVal += " + " + curr.value().toString();
            }

            curr = curr.next();
        }

        return retVal;
    }

}

class ListNode{

    private Monomial value;
    private ListNode next, prev;

    public ListNode(Monomial m){
        this.value = m;
    }

    public Monomial value() {
        return value;
    }

    public void setValue(Monomial value) {
        this.value = value;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode prev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
}