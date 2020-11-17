package java.datastructures;

public class TestClass {

    public static void main(String[] args) {

        //***** Test RingList

        RingList rList = new RingList();
        DoubleLinkedRingList drList = new DoubleLinkedRingList();

        rList.add("Hallo");
        rList.add("Welt");
        rList.add("!");

        drList.addFirst("Hallo");
        drList.addFirst("Welt");
        drList.addLast("!");

        System.out.println(rList);

        rList.remove();
        System.out.println(rList);

        //***** Test LinkedList

        LinkedList linkedList = new LinkedList();

        linkedList.add("Hallo");
        linkedList.add("Welt");


        //***** Test DoublyLinkedList

        DoublyLinkedList dl = new DoublyLinkedList();

        dl.add("Hallo");
        dl.add("Welt");
        dl.add("oder/or");
        dl.add("Hello");
        dl.add("World");


        //***** Test DoubleEndedQueue

        DoubleEndedQueue dqueue = new DoubleEndedQueue();


        System.out.println("\nEnd");
    }



}
