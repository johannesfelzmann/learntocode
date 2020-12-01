package datastructures.nodes;

//created for preparation of EP2 exam @TU Wien 2020
public class DoubleLinkedListNode {

    private String value;
    public DoubleLinkedListNode prev, next;

    public DoubleLinkedListNode(String v, DoubleLinkedListNode p, DoubleLinkedListNode n){
        this.value = v;
        this.prev = p;
        this.next = n;
    }

    //for DoubleLinkedRingList
    public DoubleLinkedListNode(String v){
        this.value = v;
        this.next = this.prev = this;
    }

    public String value() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DoubleLinkedListNode add(String v){
        this.next = this.next.prev = new DoubleLinkedListNode(v, this, this.next);
        return this.next;
    }

    public DoubleLinkedListNode remove(){
        this.next.prev = prev;
        this.prev.next = next;
        return this;
    }

}
