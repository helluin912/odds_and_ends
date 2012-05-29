import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Find_commonTest {
	@Test public void testFoo(){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3, 5};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {1, 7, 5, 0};
		for (int i : l2){
			list2.add(i);
		}
		//changes value of high from null to 1 to 5
		assertEquals(new Integer(5), Find_common.findnum(list1, list2));
	}
	
	@Test public void test2(){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {7, 5, 6};
		for (int i : l2){
			list2.add(i);
		}
		//no numbers in common
		assertEquals(null, Find_common.findnum(list1, list2));
		
	}
	
	@Test public void test3(){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {1, 1, 4, 7, 5, 6};
		for (int i : l2){
			list2.add(i);
		}
		//duplicate number in list2 that also happens to be in list 1
		assertEquals(new Integer(1), Find_common.findnum(list1, list2));
		
	}
	
	@Test public void test4(){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3, 2, 1};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {7, 5, 6, 3};
		for (int i : l2){
			list2.add(i);
		}
		//duplicate in list 1 & has a # in common w/ both lists
		assertEquals(new Integer(3), Find_common.findnum(list1, list2));
		
	}
	
	@Test public void test5(){
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {7, 5, 6};
		for (int i : l2){
			list2.add(i);
		}
		//list1 is the empty list
		assertEquals(null, Find_common.findnum(list1, list2));
	}
	
	@Test public void test6(){
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		//list1 & list2 are the empty list
		assertEquals(null, Find_common.findnum(list1, list2));
	}
	
	@Test public void test7(){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3, 2, 1};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		//list2 is the empty list
		assertEquals(null, Find_common.findnum(list1, list2));
		
	}
	
	@Test public void test8(){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3, 4, 5, 0, 9};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {1, 2, 3, 4, 5, 0, 9};
		for (int i : l2){
			list2.add(i);
		}
		//list1 = list2
		assertEquals(new Integer(9), Find_common.findnum(list1, list2));
		
	}
}
