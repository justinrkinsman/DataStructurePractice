public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    };

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(node1);
        System.out.println(result);
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        int length = 0;
        while (current != null) {
            previous = current;
            current = current.next;
            length++;
        }
        int midway = length;
        for (int i = 0; i < midway; i++) {
            previous = current;
            current = current.next;
        }
        return true;
    }
}
