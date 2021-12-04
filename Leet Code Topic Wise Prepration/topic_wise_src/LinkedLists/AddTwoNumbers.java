package LinkedLists;

import Common.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummy = result;
        int carry = 0;
        while(l1 != null || l2 != null){
            int curr = 0;
            if(l1 != null){
                curr += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                curr += l2.val;
                l2 = l2.next;
            }
            curr += carry;
            carry = curr/10;
            dummy.next = new ListNode(curr%10);
            dummy = dummy.next;
        }
        if(carry != 0){
            dummy.next = new ListNode(carry);
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
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		AddTwoNumbers a = new AddTwoNumbers();
		a.printll(a.addTwoNumbers(l1, l2));

	}

}
