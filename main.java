import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{
        public static Node head;
        public  Node tail;
        public int size;

        public  void addFirst(int data){
            //step1 = create new node
            Node newnode = new Node(data);
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
            Node newnode = new Node(data);
            size++;
            if(head == null){
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;
        }

        public  void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void add(int idx,int data){
            if(idx == 0){
                addFirst(data);
                return;
            }
            Node newnode = new Node(data);
            size++;
            Node temp = head;
            int i = 0;
            while(i < idx - 1){
                temp = temp.next;
                i++;
            }

            //i = idx - 1;temp -> prev
            newnode.next = temp.next;
            temp.next = newnode;
        }

        public int removeFirst(){
            if(size == 0){
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        public int removeLast(){
            if(size == 0){
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            //prev :i = size -2
            Node prev = head;
            for(int i = 0;i< size - 2;i++){
                prev = prev.next;
            }
            int val = prev.next.data;
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }

        public int itrSearch(int key){
            Node temp = head;
            int i = 0;
            while(temp != null){
                if(temp.data == key){
                    return i;
                }
                temp = temp.next;
                i++;
            }
            return -1;
        }

        public int helper(Node head,int key){
            if(head == null){
                return -1;
            }

            if(head.data == key){
                return 0;
            }
            int idx = helper(head.next,key);
            if(idx == -1){
                return -1;
            }
            return idx +1;
        }
        public int resaecrh(int key){
            return helper(head,key);
        }

        public void reversell(){
            Node prev = null;
            Node curr = tail = head;
            Node next;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr= next;
            }
            head = prev;
        }

        public void deleteNth(int n){
            int sz= 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                sz++;
            }
            if(n == sz){
                head = head.next;
                return;
            }
            //sz - n
            int i = 1;
            int Tofind = sz - n;
           Node prev = head;
            while(i < Tofind){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;

        }

        public Node findMid(Node head){
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next; //+1
                fast = fast.next.next; //+2
            }
            return slow; //slow is my midnode
        }

        public boolean checkpalndrome(){
            if(head == null || head.next == null){
                return true;
            }
            //step1 = find mid
            Node midnode = findMid(head);
            //step 2 = reverse 2nd half
            Node prev = null;
            Node curr = midnode;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;
            Node left = head;
            //step 3 = check left half and right half
            while(right != null){
                if(left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        public static boolean isCycle(){
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }

        public static void removeCycle(){
            //detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false ;
            while(fast != null && fast.next != null){
                slow = slow.next;//slow +1
                fast = fast.next.next;//fast +2
                if(slow == fast){
                    cycle = true;
                    break;
                }
            }
            if(cycle == false){
                return;
            }
            //find meeting point
            slow = head;
            Node prev = null;
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            //removecycle -> last.next = null
            if (prev != null) {
                prev.next = null;
            } else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }

        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.print();
//        ll.addFirst(2);
////        ll.print();
//        ll.addFirst(1);
////        ll.print();
//        ll.addLast(2);
////        ll.add(2,9);
////        ll.print();
//        ll.addLast(3);
//        ll.add(2,9);
//        ll.print();
//        ll.removeFirst();
//        ll.print();
//        ll.removeLast();
//        ll.print();
//        ll.reversell();
//        ll.print();
//        ll.deleteNth(2);
//        ll.print();
//        System.out.print(ll.checkpalndrome());
//        ll.print();
//        System.out.println(ll.itrSearch(3));
//        System.out.println(ll.itrSearch(10));
//        System.out.println(ll.resaecrh(9));
//        System.out.print(ll.size);

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.head.next.next.next = ll.head;  // Creating a cycle for testing

        System.out.println(ll.isCycle());  // Should print true
        LinkedList.removeCycle();
        System.out.println(ll.isCycle());
//
    }
}

