import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
The following was a coding question I had on a job application.

There are two unsorted lists containing integers. Provide a solution to find the largest common integer in both lists (findLargest(List<Integer> list1, List<Integer> list2)). You can use additional data structures if needed but utility methods from java collections are not allowed. There are many solutions possible for this problem; please provide the most efficient solution you can come up with and provide its running time in Big O notation. 
*/

public class Find_common{
	public static Integer findnum (List<Integer> list1, List<Integer> list2){
		Set<Integer> nums = new HashSet<Integer>();
		for (Integer i: list1){
			nums.add(i);
		}
		
		Integer high = null;
		for(Integer i: list2){
			if (nums.contains(i) && (high == null || high < i)){
					high = i;
					//System.out.println(i);
			}
		}
		return high;
	}
	
	public static void main (String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {1, 2, 3, 5, 2};
		for (int i : l1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {7, 5, 5, 1, 0, 3};
		for (int i : l2){
			list2.add(i);
		}
		
		Integer hi_common = findnum(list1, list2);
		System.out.println("Largest common # between the two lists is: " + hi_common);
	}
}
