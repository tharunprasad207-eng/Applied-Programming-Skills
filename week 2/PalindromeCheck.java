class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeCheck {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // Step 3: Compare
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Example: 1 → 2 → 3 → 2 → 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        System.out.println("Is Palindrome: " + result);
    }
}
