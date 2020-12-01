package datastructures;

import datastructures.nodes.ListNode;

//created for preparation of EP2 exam @TU Wien
public class RingList {

    private ListNode nil;

    public RingList(){

        nil = new ListNode(null, null);
        nil.setNext(nil);

    }

    //adds value to ringlist
    public boolean add(String s){

        if(search(s)){
            return false;
        }

        nil.setValue(s);
        nil.setNext(nil = new ListNode(null, nil.next()));

        return true;
    }

    public void remove(){
        ListNode n = nil.next();
        nil.setNext(n.next());
    }

    //checks if value is in the ringlist
    public boolean search(String s){
        ListNode n = nil.next();

        while(n != nil){

            if(n.value().equals(s)){
                return true;
            }

            n = n.next();

        }

        return false;
    }

    @Override
    public String toString() {
        ListNode n = nil.next();
        String retVal = "";

        while( n != nil){
            retVal = retVal + n.value() + " ";
            n = n.next();
        }

        return retVal;
    }
}
