package datastructures;

import datastructures.nodes.DoubleLinkedListNode;

//created for preparation of EP2 exam @TU Wien 2020
public class DoubleLinkedRingList {

    private DoubleLinkedListNode nil;

    public DoubleLinkedRingList(){
        nil = new DoubleLinkedListNode(null);
    }

    public void addFirst(String v){
        nil.add(v);
    }

    public void addLast(String v){
        nil.setValue(v);
        nil = nil.add(null);
    }

    public String pollFirst(){
        return nil.next.remove().value();
    }

    public String pollLast(){
        return nil.prev.remove().value();
    }

    public String peekFirst(){
        return nil.next.value();
    }

    public String peekLast(){
        return nil.prev.value();
    }

    public boolean isEmpty(){
        return nil.next == nil;
    }

}
