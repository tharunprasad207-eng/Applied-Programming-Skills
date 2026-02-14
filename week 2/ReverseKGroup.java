class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {

            // Find kth node
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            if (kth == null)
                break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // Reverse group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect reversed group
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int k = 3;

        System.out.println("Original List:");
        printList(head);

        ListNode result = reverseKGroup(head, k);

        System.out.println("Reversed in Groups of " + k + ":");
        printList(result);
    }
}
