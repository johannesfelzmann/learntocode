package ep2exam;

import java.io.*;

//some code you have to know for the EP2 Exam
public class EPExam {

    public static void main(String[] args) throws IOException {

     /*   Reader r = new FileReader("jo");
        BufferedReader breader = new BufferedReader(r);

        while(breader.readLine() != null){

        }*/

     ListStack li = new ListStack();

     li.push("1");
     li.push("3");
     li.push("1");
     li.push("2");

     li.print();

     li.poll();
     System.out.println("\n");

     li.print();


    }


}

class ListStack{

    private Node head;

    public void push(String s){
        if(head == null){
            head = new Node(s, null);
        }else{
            Node last = head;
            while(last.next() != null){
                last = last.next();
            }
            last.setNext(new Node(s, null));
        }
    }

    public String poll(){
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
    }

    public void print(){
        Node last = head;

        while(last != null){

            System.out.print(last.value() + " ");

            last = last.next();
        }
    }

}

class Node{
    private String val;
    private Node next;

    public Node(String v, Node n){
        this.val = v;
        this.next = n;
    }

    public String value() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}




