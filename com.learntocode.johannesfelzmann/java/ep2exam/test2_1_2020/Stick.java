package java.ep2exam.test2_1_2020;

import java.util.NoSuchElementException;
import java.util.Objects;

// A 'Stick' has a specified weight, that can not be changed after
// initialisation. On the left and right end of the stick further mobiles are attached
// (recursive structure).
//
public class Stick implements Mobile {

    private int weight;
    private Mobile left, right;

    public Stick(int w, Mobile l, Mobile r) throws MobileUnbalancedException {
        if (l.getWeight() != r.getWeight()) {
            throw new MobileUnbalancedException(
                    String.format("Mobile unbalanced (left: %s - right: %s)", l.getWeight(), r.getWeight()));
        }
        this.left = l;
        this.right = r;
        this.weight = w;
    }

    @Override
    public int getWeight() {
        return this.weight + left.getWeight() + right.getWeight();
    }

    @Override
    public MobileIterator iterator() {
        return new StickIterator(left.iterator(), right.iterator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stick stars = (Stick) o;
        return weight == stars.weight && ((left.equals(stars.right) && right.equals(stars.left)) || (left.equals(stars.left) && right.equals(stars.right)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight * left.getWeight() * right.getWeight());
    }

    @Override
    public String toString() {
        return "(" + left.toString() + ")" + "-" + this.weight + "(" + right.toString() + ")";
    }
}

class StickIterator implements MobileIterator{

    MobileIterator left, right;

    public StickIterator(MobileIterator l, MobileIterator r){
        this.left = l;
        this.right = r;
    }

    @Override
    public boolean hasNext() {
        return left.hasNext() || right.hasNext();
    }

    @Override
    public Star next() {
        if(left.hasNext()){
            return left.next();
        }else if(right.hasNext()){
            return right.next();
        }else{
            throw new NoSuchElementException("no more star!");
        }
    }
}
