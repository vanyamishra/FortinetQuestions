/**
 * Reverse a LinkedList - Test Cases
 * @author vanyamishra
 */
package reverseLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseNodeTest {

	@Test
	public void reverseTest_NullList() {
		Node reverseHead = new Node();
		reverseHead = reverseHead.reverse(null);
		assertNull(reverseHead);
	}
	
	@Test
	public void reverseTest_SingleElement() {
		Node reverseHead = new Node();
		reverseHead.value = 1;
		reverseHead = reverseHead.reverse(reverseHead);
		assertEquals(reverseHead.value,1);
	}
	
	@Test
	public void reverseTest_List() {
		
		//Initiating a list with 3 elements.
		
		Node head = new Node();
		Node second = new Node();
		Node third = new Node();
		
		third.value = 3;
		second.value = 2;
		head.value = 1;
		
		second.next = third;
		head.next = second;
		
		//Initiating the expected reversed list.
		
		Node reverseHead = new Node();
		Node reverseSecond = new Node();
		Node reverseThird = new Node();
		
		reverseHead.value = 3;
		reverseSecond.value = 2;
		reverseThird.value = 1;
		
		reverseSecond.next = reverseThird;
		reverseHead.next = reverseSecond;
		
		Node reverseList = head.reverse(head);	
		
		assertEquals(reverseList.value, reverseHead.value);
		assertEquals(reverseList.next.value, reverseHead.next.value);
		assertEquals(reverseList.next.next.value, reverseHead.next.next.value);
	}

}
