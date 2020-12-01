package ep2exam.probetest4;

import java.util.*;

// This class implements 'StringOperator' and represents a simple replacement operation on a string.
// It replaces the all occurrences of the specified 'oldChar' with 'newChar'.
// The iterator of this class iterates over only one element and therefore behaves as follows:
// The 'next' method returns 'this', if it is called for the first time.
// 'hasNext' is 'true' only if 'next' has not been called.
//
public class ReplaceOperator implements StringOperator/* TODO: fix declaration. */ {

    //TODO: define variables.
    private char oldChar;
    private char newChar;

    // Constructor of the 'ReplaceOperator'.
    public ReplaceOperator(char oldChar, char newChar) {

        //TODO: implement constructor.
        this.oldChar = oldChar;
        this.newChar = newChar;

    }

    @Override
    public String apply(String operand) {
        return operand.replace(oldChar, newChar);
    }

    @Override
    public StringOperator andThen(StringOperator after) {
        return new ComposedOperator(this, after);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplaceOperator that = (ReplaceOperator) o;
        return oldChar == that.oldChar &&
                newChar == that.newChar;
    }

    @Override
    public int hashCode() {
        return (oldChar - '0') * 31 + (newChar - '0') * 31 ;
    }

    @Override
    public String toString() {
        return "replace '" + oldChar + "' with '" + newChar + "'" ;
    }

    @Override
    public Iterator<StringOperator> iterator() {
        return new ReplaceIterator(this);
    }

    //TODO: define missing parts of this class.
}

class ReplaceIterator implements Iterator<StringOperator>{

    private ReplaceOperator obj;
    private boolean first;

    public ReplaceIterator(ReplaceOperator o){
        obj = o;
        first = true;
    }

    @Override
    public boolean hasNext() {
        return first;
    }

    @Override
    public StringOperator next() {
        if(hasNext()){
            first = false;
            return obj;
        }

        throw new NoSuchElementException("no operator!");
    }
}