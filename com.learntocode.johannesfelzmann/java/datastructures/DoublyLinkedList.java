package datastructures;

import datastructures.nodes.DoubleLinkedListNode;

//constructed in preparation of EP2 exam @TU Wien 2020
public class DoublyLinkedList {

    private DoubleLinkedListNode head,last;

    public void add(String v){
        if(head == null){
            head = last = new DoubleLinkedListNode(v,null, null);
        }else{
            if(search(v)){
                return;
            }
            //add at end
            last.next = new DoubleLinkedListNode(v, last, null);
            last.next.prev = last;
            last = last.next;
        }
    }

    public boolean search(String v){
        DoubleLinkedListNode n = head;

        while (n != last) {
            if(n.value().equals(v)){
                return true;
            }
            n = n.next;
        }

        return false;
    }

}
