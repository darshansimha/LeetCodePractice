package Heap;

import java.util.PriorityQueue;

import Common.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
		ListNode root = new ListNode();
		ListNode head = root;
		for (int i = 0; i < k; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		while (!heap.isEmpty()) {
			ListNode current = heap.poll();
			if (current.next != null) {
				heap.add(current.next);
			}
			head.next = current;
			head = head.next;
		}
		return root.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
