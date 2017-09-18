/**
 * Tests for the Subsets class
 * @author vanyamishra
 */
package partition;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubsetsTest {
	  
	@Test
	public void separate_OneSubset() {
		List<Integer> list = new ArrayList<Integer>();
		Subsets obj = new Subsets();
		boolean result = obj.separate(list, 1);
		assertTrue(result);
	}

	
	@Test
	public void separate_MoreSubsetsThanSize() {
		List<Integer> list = new ArrayList<Integer>();
		Subsets obj = new Subsets();
		boolean result = obj.separate(list, 2);
		assertFalse(result);
	}
	
	@Test
	public void separate_NullList() {
		List<Integer> list = null;
		Subsets obj = new Subsets();
		boolean result = obj.separate(list, 1);
		assertTrue(result);
	}
	
	@Test
	public void separate_SeparatableList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Subsets obj = new Subsets();
		boolean result = obj.separate(list, 3);
		assertTrue(result);
	}
	
	@Test
	public void separate_NotASeparatableList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		Subsets obj = new Subsets();
		boolean result = obj.separate(list, 2);
		assertFalse(result);
	}


}
