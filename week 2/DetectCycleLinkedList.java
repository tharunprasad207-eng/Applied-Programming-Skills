class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DetectCycleLinkedList {

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null)
            return null;

        // Step 2: Find cycle start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Create cycle: 3 -> 2 -> 0 -> -4
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create cycle here (tail connects to node2)
        node4.next = node2;

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected at node value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
