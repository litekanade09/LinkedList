import java.util.LinkedList;
public class doubleLL {
    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static class LinkedList{
        public Node head;
        public Node tail;
        public int size;

        public void addFirst(int data){
            Node newnode = new Node(data);
            size++;
            if(head == null){
                head = tail = newnode;
                return;
            }
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }

        public void addLast(int data){
            Node newnode = new Node(data);
            size++;
            if(head == null){
                head = tail = newnode;
                return;
            }

            tail.next = newnode;
            tail = newnode;
        }

        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void reverse(){
            Node curr = head;
            Node prev = null;
            Node next;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                curr.prev = next;

                prev = curr;
                curr = next;
            }
            head = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);


        ll.print();
        ll.reverse();
        ll.print();
    }
}
