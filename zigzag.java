import java.util.LinkedList;
public class zigzag {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{
        public Node head;
        public Node tail;
        public int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void addFirst(int data) {
            // step1 = create new node
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            // step2 = newNode.next = head
            newNode.next = head;

            // step3 = head = newNode
            head = newNode;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {

                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void zigzagll(){
            //find mid
            Node slow = head;
            Node fast = head.next;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            //reverse 2nd half
            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;

            while(curr != null){
                next= curr.next;
                curr.next = prev;
                prev = curr;
                curr= next;
            }

            Node left = head;
            Node right= prev;
            Node nextl , nextr;
            //alt merge - zigzag merge
            while(left != null && right != null){
                nextl = left.next;
                left.next = right;
                nextr = right.next;
                right.next = nextl;

                right = nextr;
                left = nextl;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        System.out.println("kYU BE chutiye kardia na print");

        ll.print();
        ll.zigzagll();
        ll.print();
    }
}
