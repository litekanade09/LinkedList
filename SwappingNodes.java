import java.util.*;
public class SwappingNodes {
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
       public void swap(int x,int y){

           if(x == y){
               return;
           }
           Node prevX = null,currX = head;
           while(currX != null && currX.val != x){
               prevX = currX;
               currX = currX.next;
           }
           Node prevY = null,currY = head;
           while(currY != null && currY.val != y){
               prevY = currY;
               currY = currY.next;
           }
           if(currX == null || currY == null){
               return;
           }
           if(prevX != null){
               prevX.next = currY;
           }else{
               head = currY;
           }
           if(prevY != null){
               prevY.next = currX;
           }else{
               head = currX;
           }
           Node temp = currX.next;
           currX.next = currY.next;
           currY.next = temp;
       }
       public void push(int newval){
           Node newNode = new Node(newval);
           newNode.next = head;
           head = newNode;
       }
       public void print(){
           Node tNode = head;
           while(tNode != null){
               System.out.print(tNode.val + " ");
               tNode = tNode.next;
           }
       }
   }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.print("LinkedList is: ");
        list.print();

        list.swap(4,3);
        System.out.println("Swapping LinkedList: ");
        list.print();

    }
}
