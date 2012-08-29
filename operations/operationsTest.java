package operations;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class operationsTest {
	public static String retVals (List<Integer> list){
		String vals = "";
		for(int i:list){
			vals = vals + i + " ";
		}
		return vals;
	}
	
	@Test public void make_nonempty_list() {
		int[] nums = {3,7,3,9,5,0};
		List<Integer> list = new ArrayList<Integer>();
		list = operations.makeList(nums);
		String exp = "3 7 3 9 5 0 ";
		String result = retVals(list);
		assertEquals(exp, result);
	}
	
	@Test public void make_empty_list() {
		List<Integer> list = new ArrayList<Integer>();
		list = operations.makeList(new int[]{});
		String exp = "";
		String result = retVals(list);
		assertEquals(exp, result);
	}
	
	@Test public void remove_duplicates(){
		//there are multiple duplicates in this example
		List<Integer> list = new ArrayList<Integer>();
		int[] nums = {1,2,4,2,6,7,2,4,1,2};
		list = operations.makeList(nums);
		list = operations.rmdupes(list);
		String exp = "1 2 4 6 7 ";
		String result = retVals(list);
		assertEquals(exp, result);
	}
	
	@Test public void remove_duplicates2(){
		//there are no duplicates
		List<Integer> list = new ArrayList<Integer>();
		int[] nums = {1,2,3,5,7,11};
		list = operations.makeList(nums);
		list = operations.rmdupes(list);
		String exp = "1 2 3 5 7 11 ";
		String result = retVals(list);
		assertEquals(exp, result);
	}
	
	@Test public void remove_duplicates3(){
		//empty list
		List<Integer> list = new ArrayList<Integer>();
		list = operations.makeList(new int[]{});
		list = operations.rmdupes(list);
		String exp = "";
		String result = retVals(list);
		assertEquals(exp, result);
	}
	
	@Test public void union1(){
		//1 is duplicated in both lists
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {1,2,3,4,5,1};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {1,4,5,1,7,9,0};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.union(list1, list2);
		
		String exp = "0 1 2 3 4 5 7 9 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void union2(){
		//both lists have different numbers duplicated
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {1,2,3,4,5,1};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {0,3,7,8,4,3};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.union(list1, list2);
		
		String exp = "0 1 2 3 4 5 7 8 ";
		String result = retVals(res);
		assertEquals(exp,result);
	}
	
	@Test public void union3(){
		//union of list1 and the empty set
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,1,2,3,4,5};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2 = operations.makeList(new int[]{});
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.union(list1, list2);
		
		String exp = "0 1 2 3 4 5 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void union4(){
		//union of list1 and list1
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,1,2,3,4,5};
		list1 = operations.makeList(nums1);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.union(list1, list1);
		
		String exp = "0 1 2 3 4 5 ";
		String result = retVals(res);
		assertEquals(exp, result);
		
	}
	
	@Test public void union5(){
		//no duplicates at all. lists have no numbers in common
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,2,4,6};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {1,3,5,7};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.union(list1, list2);
		
		String exp = "0 1 2 3 4 5 6 7 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}

	@Test public void intersection1() {
		//1 is duplicated in both lists
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {1,2,3,4,5,1};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {1,4,5,1,7,9,0};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.intersect(list1, list2);
		String exp = "1 4 5 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void intersection2(){
		//both lists have different numbers duplicated
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {1,2,3,4,5,1};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {0,3,7,8,4,3};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.intersect(list1, list2);
		
		String exp = "3 4 ";
		String result = retVals(res);
		assertEquals(exp,result);
	}
	
	@Test public void intersection3(){
		//no duplicates at all
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,1,2,3,4,5};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2 = operations.makeList(new int[]{});
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.intersect(list1, list2);
		
		String exp = "";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void intersection4(){
		//intersection of list1 and list1 = list1
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,1,2,3,4,5};
		list1 = operations.makeList(nums1);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.intersect(list1, list1);
		
		String exp = "0 1 2 3 4 5 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}

	@Test public void sym_diff1(){
		//1 is duplicated in both lists
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {1,2,3,4,5,1};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {1,4,5,1,7,9,0};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.sym_diff(list1, list2);
		String exp = "2 3 7 9 0 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void sym_diff2(){
		//both lists have different numbers duplicated
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {1,2,3,4,5,1};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {0,3,7,8,4,3};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.sym_diff(list1, list2);
		String exp = "1 2 5 1 0 7 8 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void sym_diff3(){
		//no duplicates at all. neither list is the empty list. all unique numbers
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,2,4,6};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] nums2 = {1,3,5,7};
		list2 = operations.makeList(nums2);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.sym_diff(list1, list2);
		String exp = "0 2 4 6 1 3 5 7 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}
	
	@Test public void sym_diff4(){
		//list2 is the empty list
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,1,2,3,2,4,5};
		list1 = operations.makeList(nums1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2 = operations.makeList(new int[]{});
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.sym_diff(list1, list2);
		String exp = "0 1 2 3 2 4 5 ";
		String result = retVals(res);
		assertEquals(exp, result);
	}

	@Test public void sym_diff5(){
		//symmetric difference of list1 and list1
		List<Integer> list1 = new ArrayList<Integer>();
		int[] nums1 = {0,1,2,3,2,4,5};
		list1 = operations.makeList(nums1);
		
		List<Integer> res = new ArrayList<Integer>();
		res = operations.sym_diff(list1, list1);
		String exp = "";
		String result = retVals(res);
		assertEquals(exp, result);
	}
}
