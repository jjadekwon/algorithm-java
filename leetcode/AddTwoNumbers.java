package leetcode;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode nextNode = null;
		ListNode result = null;
		int next = 0;
		while (true) {
			if (l1 == null && l2 == null) break;

			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			
			int sum = val1 + val2 + next;
			
			if (result == null) {
				result = new ListNode(sum % 10);
				nextNode = result;
			}
			else {
				nextNode.next = new ListNode(sum % 10);
				nextNode = nextNode.next;
			}

			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;

			next = sum / 10;
		}
		
		if (next != 0) nextNode.next = new ListNode(next);
		
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
