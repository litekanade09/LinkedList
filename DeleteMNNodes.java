import java.util.*;
public class DeleteMNNodes {
    public static class Node{
        int data;
        Node next;
        public Node(){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{
       public static Node push(Node headref,int nodedata){
            Node newNode = new Node();
            newNode.data = nodedata;
            newNode.next = (headref);
            (headref) = newNode;
            return headref;
       }
       public static void print(Node head){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("null");
       }

        public static void delete(Node head,int M,int N){
            Node curr = head,t;
            int count;

            while(curr != null){
                for(count = 1;count < M && curr != null;count++){
                    curr = curr.next;
                }
                if(curr == null){
                    return;
                }
                t = curr.next;
                for(count = 1;count <= N && t != null; count++){
                    Node temp = t;
                    t = t.next;
                }
                curr.next = t;
                curr = t;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head = null;

        head = list.push(head,10);
        head = list.push(head,9);
        head = list.push(head,8);
        head = list.push(head,7);
        head = list.push(head,6);
        head = list.push(head,5);
        head = list.push(head,4);
        head = list.push(head,3);
        head = list.push(head,2);
        head = list.push(head,1);

        list.print(head);

        int M= 3,N = 2;
        list.delete(head,M,N);

        System.out.println("LinkedList After Deletion");
        list.print(head);
    }
}
