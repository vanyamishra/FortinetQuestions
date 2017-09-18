/**
 * Reverse a LinkedList
 * @author vanyamishra
 */

package reverseLinkedList;

public class Node {

	Node next;
	int value;

	public Node reverse(Node head) {

		/*
		 * Given a linked list, [1 -> 2 -> 3 -> null], the reversed linked list
		 * must appear as [3 -> 2 -> 1 -> null].
		 * 
		 * For this list, this can be achieved in 3 steps in the following
		 * sequence,
		 * Step 1: 1 -> null (where 1 is the current node, and null is its previous node)
		 * Step 2: 2 -> 1 -> null (where 2 is the current node, and (1->null) is the previous node)
		 * Step 3: 3 -> 2 -> 1 -> null
		 * (where 3 is the current node, and (2->1->null) is the previous node) 
		 * 
		 */

		Node previous = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	// Time complexity: O(n) 
	// Space complexity: O(1)

}
