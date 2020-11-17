package java.datastructures;

//constructed in preparation of EP2 exam @TU Wien 2020
public class DoubleEndedQueue {

    private int mask;
    private String[] es;
    private int head,tail;

    public DoubleEndedQueue(){

        this.mask = (1 << 3) - 1;
        this.es = new String[mask + 1];

    }


    public void addFirst(String e){
        es[head = (head-1) & mask] = e;
        if(tail == head){
            doubleCapacity();
        }
    }

    public String pollFirst(){
        String result = es[head];
        es[head] = null;
        if(tail != head){
            head = (head + 1) & mask;
        }
        return result;
    }

    public String peekFirst(){
        return es[head];
    }

    public void addLast(String e){
        es[tail = (tail + 1) & mask] = e;
        if(tail == head){
            doubleCapacity();
        }
    }

    public String pollLast(){
        if(tail != head){
            tail = (tail - 1) & mask;
        }
        String result = es[tail];
        es[tail] = null;
        return result;
    }

    public String peekLast(){
        return es[(tail - 1) & mask];
    }

    private void doubleCapacity() {
        mask = (mask << 1) | 1;
        String[] newes = new String[mask + 1];

        int j = 0;
        for (int i = 0; i < head;) {
            newes[i++] = this.es[j++];
        }
        j = head += this.es.length;

        for (int i = 0; i < es.length;) {
            newes[j++] = es[i++];
        }

        es = newes;

    }


}
