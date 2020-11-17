package java.ep2exam.test1_1_2020;

// A sorted linked list of celestial bodies. The list is ordered
// lexicographically according to the names of the celestial bodies.
//
public class CelestialSystem {
    
    ListN head;

    public CelestialSystem(){}
    // Inserts the specified 'body' into the sorted list only if there is no body in the list with
    // the same name as that of 'body'. Returns 'true' if the list was changed as a result of the
    // call, 'false' otherwise.
    public boolean add(CelestialBody body) {


            
            if (head == null) {
                head = new ListN(body, null);

                return true;
            }else{
                if(head.search(body) == null) {
                    head = head.add(body);
                    return true;
                }
            }

        return false;
    }

    // Returns the index (position) of the body with the specified name in the sorted list.
    // Celestial bodies are ordered lexicographically according to their names.
    // The first entry in this lexicographical order has index 0.
    // Returns -1 of there is no body in the list with the specified name.
    // Precondition: name != null.
    public int indexof(String name) {
        return head.indexOf(new CelestialBody(name, 0));
    }

    // Returns the body with the specified name or 'null' if no such body exits in the list.
    // Precondition: name != null.
    public CelestialBody get(String name){
       return head.search(new CelestialBody(name, 0));
    }

    // returns the number of entries of the list.
    public int size() {
        return head.size();
    }

    // Returns a readable representation of all bodies of this system
    // lexicographically ordered according to their name.
    public String toString() {
        return head.toString();
    }

}

class ListN{

    private CelestialBody value;
    private ListN next;

    public ListN(CelestialBody v, ListN next){
        this.value = v;
        this.next = next;
    }

    public ListN add(CelestialBody body) {

        int cmp =  this.value.compareTo(body);

        if(cmp < 0){

            if(this.next == null){
                this.next = new ListN(body, null);
                return this;
            }else{
                this.next = this.next.add(body);
                return this;
            }

        }else{
            return new ListN(body, this);
        }

    }

    public CelestialBody search(CelestialBody celestialBody) {

        ListN curr = this;

        while(curr != null){
            if(curr.value.compareTo(celestialBody) == 0){
                return curr.value;
            }
            curr = curr.next;
        }

        return null;
    }

    @Override
    public String toString() {
        String retVal = "" + this.value.toString();
        ListN curr = this.next;
        while(curr != null){
            retVal += "\n" + curr.value.toString();
            curr = curr.next;
        }

        return retVal;
    }

    public int size() {
        int cnt = 0;
        ListN curr = this;
        while(curr != null){
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }

    public int indexOf(CelestialBody celestialBody) {
        int idx = 0;
        ListN curr = this;

        while(curr != null){
            if(curr.value.compareTo(celestialBody) == 0){
                return idx;
            }
            idx++;
            curr = curr.next;
        }

        return -1;
    }
}
