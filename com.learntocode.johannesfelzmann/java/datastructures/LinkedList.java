package datastructures;

import datastructures.nodes.ListNode;

//created for preparation of EP2 exam @TU Wien 2020
public class LinkedList {

    //use List as Stack:
    /*
    private ListNode head;

    public void push(String v){
        head = new ListNode(v, head);
    }

    public String pop(){
        if(head != null){
            String retVal = head.value();
            head = head.next();
            return retVal;
        }
        return null;
    }

    public String peek(){
        if(head != null){
            return head.value();
        }

        return null;
    }*/

    //use List as Queue

    private ListNode head, last;

    public void add(String v){
        if(head == null){
            head = last = new ListNode(v, null);
        }else{

            if(search(v)){
                return;
            }

            last.setNext( last = new ListNode(v, null));
        }
    }

    public boolean search(String s){
        ListNode n = head;

        while(n != last){
            if(n.value().equals(s)){
                return true;
            }
            n = n.next();
        }

        return false;
    }

    public String get(int idx){

        if(head != null){
            ListNode n = head;
            int i = 0;
            while(n != last){

                if (i == idx){
                    return n.value();
                }

                i++;
                n = n.next();
            }
        }

        return null;
    }


}
