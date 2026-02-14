class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionLinkedList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // either intersection node or null
    }

    public static void main(String[] args) {

        // Shared part: 8 -> 10
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // List A: 3 -> 7 -> 8 -> 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        // List B: 99 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node value: " + in
