package ep2exam.probetest4;

import java.util.*;

// This class implements 'StringOperator' and represents a composition of two 'StringOperator' objects that
// are applied in succession (both can be 'ComposedOperator' objects themselves).
// Calling this object's 'apply' method returns the result of applying the second 'StringOperator'
// on the result of applying the first one on the specified string.
// 'ComposedOperator' objects can be build using the 'andThen' method specified in the interface 'StringOperator'.
//
public class ComposedOperator implements StringOperator/* TODO: fix declaration. */ {

    private StringOperator operator1;
    private StringOperator operator2;

    public ComposedOperator(StringOperator op1, StringOperator op2){
        this.operator1 = op1;
        this.operator2 = op2;
    }

    @Override
    public String apply(String operand) {
        return operator1.apply(operator2.apply(operand));
    }

    @Override
    public StringOperator andThen(StringOperator after) {
        return new ComposedOperator(this, after);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposedOperator that = (ComposedOperator) o;
        return operator1.equals(that.operator1) && operator2.equals(that.operator2);
    }

    @Override
    public int hashCode() {
        return operator1.hashCode() * operator2.hashCode();
    }

    @Override
    public String toString() {
        return operator1.toString() + " and then " + operator2.toString();
    }

    @Override
    public Iterator<StringOperator> iterator() {
        return new ComposedIterator(operator1, operator2);
    }

    //TODO: define missing parts of this class.

}

class ComposedIterator implements Iterator<StringOperator>{

    private Iterator iter1;
    private Iterator iter2;

    public ComposedIterator(StringOperator o1, StringOperator o2){
        iter1 = o1.iterator();
        iter2 = o2.iterator();
    }

    @Override
    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }

    @Override
    public StringOperator next() {

        if(hasNext()){
            if(iter1.hasNext()){
                return (StringOperator) iter1.next();
            }else if(iter2.hasNext()){
                return (StringOperator) iter2.next();
            }
        }

        throw new NoSuchElementException("no operator!");
    }
}