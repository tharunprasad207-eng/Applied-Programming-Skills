import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        // Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        // Add first node of each list
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        // List 1: 1 -> 4 -> 7
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);

        // List 2: 2 -> 5 -> 8
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(8);

        // List 3: 3 -> 6 -> 9
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(6);
        l3.next.next = new ListNode(9);

        ListNode[] lists = {l1, l2, l3};

        ListNode mer
