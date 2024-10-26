import java.util.ArrayList;
import java.util.LinkedList;
public class detectcycle {
    public static class Node{
        int data;
        main.Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{
        public main.Node head;
        public main.Node tail;
        public int size;
        public  void addFirst(int data){
            //step1 = create new node
            main.Node newnode = new main.Node(data);
            size++;
            if(head == null){
                head = tail = newnode;
                return;
            }
            //step2 = newnode next = head
            newnode.next= head;

            //step3 = head = newnode
            head = newnode;
        }

        public  void addLast(int data) {
            main.Node newnode = new main.Node(data);
            size++;
            if(head == null){
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;
        }

        public  void print(){
            main.Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }


        public  boolean isCycle(){
            main.Node slow = head;
            main.Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }

            }
            return false;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.head.next.next.next = ll.head.next;
        System.out.println(ll.isCycle());


    }
}
