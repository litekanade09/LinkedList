import java.util.LinkedList;
public class OddEvenLinkedList {
    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static class LinkedList{
        Node head;
        public void OddEven(){
            Node end = head;
            Node prev = null;
            Node curr = head;
            while(end.next != null){
                end = end.next;
            }
            Node newend = end;

            while(curr.val % 2 != 0 && curr != end){
                newend.next = curr;
                curr = curr.next;
                newend.next.next = null;
                newend = newend.next;
            }
            if(curr.val % 2 == 0){
                head = curr;
                while (curr != end){
                    if(curr.val % 2 == 0){
                        prev = curr;
                        curr = curr.next;
                    }else{
                        prev.next = curr.next;
                        curr.next = null;
                        newend.next = curr;
                        newend = curr;
                        curr = prev.next;
                    }
                }
            }else{
                prev = curr;
                if(newend != end && end.val % 2 != 0){
                    prev.next = end.next;
                    end.next = null;
                    newend.next = end;
                }
            }
        }

        public void push(int newval){
            Node newNode = new Node(newval);
            newNode.next = head;
            head = newNode;
        }

        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print("null");
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(2);
        list.push(3);
        list.push(6);
        list.push(8);
        list.push(9);
        list.push(5);

        System.out.print("LinkedList is: ");
        list.print();

        list.OddEven();
        System.out.print("New Linked IS: ");
        list.print();
    }
}
