package Dec_04;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode result = new ListNode();
		ListNode head = result;
		int currSum = 0;
		int carry = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				currSum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				currSum += l2.val;
				l2 = l2.next;
			}

			currSum += carry;

			carry = currSum / 10;

			head.next = new ListNode(currSum % 10);
			head = head.next;
			currSum = 0;
		}

		if (carry != 0) {
			head.next = new ListNode(carry);
		}

		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
