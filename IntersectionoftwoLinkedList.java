import java.util.*;

public class IntersectionoftwoLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headB != null) {
            ListNode temp = headA;
            while (temp != null) {
                if (temp == headB) {
                    return headB;
                }
                temp = temp.next;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionoftwoLinkedList list = new IntersectionoftwoLinkedList();

        ListNode headA = new ListNode(10);
        ListNode headB = new ListNode(3);

        ListNode newNode = new ListNode(6);
        headB.next = newNode;

        newNode = new ListNode(9);
        headA.next = newNode;

        newNode = new ListNode(15);
        headA.next.next = newNode;
        headB.next.next = newNode;

        newNode = new ListNode(30);
        headA.next.next.next = newNode;

        headA.next.next.next.next = null;

        ListNode Intersection = list.getIntersectionNode(headA, headB);

        if (Intersection == null) {
            System.out.print("No Intersection point");
        } else {
            System.out.print("Intersection point: " + Intersection.val);
        }
    }
}
