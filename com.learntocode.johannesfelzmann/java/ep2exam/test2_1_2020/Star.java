package ep2exam.test2_1_2020;

import java.util.NoSuchElementException;
import java.util.Objects;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight, that can not be changed after
// initialisation.
//
public class Star implements Mobile {

    private int weight;

    public Star(int w){
        this.weight = w;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return weight == star.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public String toString() {
        return "*" + weight;
    }


    @Override
    public MobileIterator iterator() {
        return new StarIterator(this);
    }
}

class StarIterator implements MobileIterator{

    private Star star;

    public StarIterator(Star s){
        star = s;
    }

    @Override
    public boolean hasNext() {
        return star != null;
    }

    @Override
    public Star next() {
        if(!hasNext()){
            throw new NoSuchElementException("no more star!");
        }

        Star ret = star;
        star = null;
        return ret;
    }
}