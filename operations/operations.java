package operations;
import java.util.*;
public class operations {
	public static List<Integer> rmdupes (List<Integer> list){
		//removes duplicate numbers from list
		Set<Integer> s = new HashSet<Integer>();
		s.addAll(list);
		list.clear();
		list.addAll(s);
		return list;
	}
	
	public static void printList (List<Integer> list){
		for (int i: list){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> makeList(int[] nums){
		List<Integer> retList = new ArrayList<Integer>();
		for (int i:nums){
			retList.add(i);
		}
		return retList;
	}
	
	public static List<Integer> union (List<Integer> list1, List<Integer> list2){
		//returns the union of list1 & list2 as a List
		Set<Integer> nums = new HashSet<Integer>();
		nums.addAll(list1);
		nums.addAll(list2);
		List<Integer> incommon = new ArrayList<Integer>();
		incommon.addAll(nums);
		return incommon;
	}
	
	public static List<Integer> intersect (List<Integer> list1, List<Integer> list2){
		//returns the intersection of list1 & list2
		list1 = rmdupes(list1);
		list2 = rmdupes(list2);
		List<Integer> nums = new ArrayList<Integer>();
		for(int i:list2){
			if(list1.contains(i)){
				nums.add(i);
			}
		}
		return nums;
	}
	
	public static List<Integer> sym_diff (Collection<Integer> list1, Collection<Integer> list2){
		//returns the symmetric difference of list1 & list2
		//symmetric difference meaning return only the numbers that are not in both lists
		List<Integer> nums = new ArrayList<Integer>();
		for(int i:list1){
			if (!list2.contains(i)){
				nums.add(i);
			}
		}
		for(int i: list2){
			if(!list1.contains(i)){
				nums.add(i);
			}
		}
		return nums;
	}
	
	public static void main (String[] args){
		List<Integer> list1 = new ArrayList<Integer>();
		int[] l1 = {0,1,2,3,4,5};
		list1 = makeList(l1);
		//printList(list1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		int[] l2 = {6,12,18,23,17};
		list2 = makeList(l2);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3 = makeList(new int[]{});
		System.out.print("list1: ");
		printList(list1);
		System.out.print("list2: ");
		printList(list2);
		System.out.print("list3: ");
		printList(list3);
		
		List<Integer> union_n = new ArrayList<Integer>();
		union_n = union(list1, list2);
		System.out.print("The union of list1 and list2: ");
		printList(union_n);
		
		List<Integer> in_common = new ArrayList<Integer>();
		in_common = intersect(list1, list2);
		System.out.print("The intersection of list1 and list2: ");
		printList(in_common);
		
		//Intersection again
		in_common = intersect(list2, list3);
		if (in_common.isEmpty()){
			System.out.println("The intersection of list2 & list3 is the empty set");
		}
		else{
			printList(in_common);
		}
		
		//Symmetric difference; in one set, but not the other
		List<Integer> diff = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		s.addAll(list2);
		diff = sym_diff(list1, s);
		System.out.print("Symmetric difference of list1 & set s = "); //should be 1, 2, 4
		printList(diff);
		
		System.out.print("Symmetric difference of list1 & empty set = "); //1, 3, 5
		diff = sym_diff(list1, list3);
		printList(diff);
	}
}
