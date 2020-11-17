package java.datastructures.nodes;

//created for preparation of EP2 exam @TU Wien 2020
public class ListNode {
    private String value;
    private ListNode next;

    public ListNode(String v, ListNode n){
        this.value = v;
        this.next = n;
    }

    public String value() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
