package LinkedLists;

import Common.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode result = new ListNode();
		ListNode dummy = result;

		while (l1 != null || l2 != null || carry == 1) {
			int sum = 0;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			sum += carry;

			carry = sum / 10;

			ListNode current = new ListNode(sum % 10);

			dummy.next = current;
			dummy = dummy.next;
		}
		return result.next;
	}

	private void printll(ListNode l1) {
		while (l1 != null) {
			System.out.print(l1.val + "->");
			l1 = l1.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		AddTwoNumbers a = new AddTwoNumbers();
		a.printll(a.addTwoNumbers(l1, l2));

	}

}
