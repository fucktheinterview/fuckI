// http://www.programcreek.com/2013/01/leetcode-subsets-java/
// Given a set S of n distinct integers, there is a relation between Sn and Sn-1. The subset of Sn-1 is the union of {subset of Sn-1} and {each element in Sn-1 + one more element}. Therefore, a Java solution can be quickly formalized.

public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	if (S == null)
		return null;
 
	Arrays.sort(S);
 
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
	for (int i = 0; i < S.length; i++) {
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
 
		//get sets that are already in result
		for (ArrayList<Integer> a : result) {
			temp.add(new ArrayList<Integer>(a));
		}
 
		//add S[i] to existing sets
		for (ArrayList<Integer> a : temp) {
			a.add(S[i]);
		}
 
		//add S[i] only as a set
		ArrayList<Integer> single = new ArrayList<Integer>();
		single.add(S[i]);
		temp.add(single);
 
		result.addAll(temp);
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
}


// Subsets II, may caontains duplicate
// http://www.programcreek.com/2013/01/leetcode-subsets-ii-java/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	if (num == null)
		return null;
 
	Arrays.sort(num);
 
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
 
	for (int i = num.length-1; i >= 0; i--) {
 
		//get existing sets
		if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
			prev = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < result.size(); j++) {
				prev.add(new ArrayList<Integer>(result.get(j)));
			}
		}
 
		//add current number to each element of the set
		for (ArrayList<Integer> temp : prev) {
			temp.add(0, num[i]);
		}
 
		//add each single number as a set, only if current element is different with previous
		if (i == num.length - 1 || num[i] != num[i + 1]) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(num[i]);
			prev.add(temp);
		}
 
		//add all set created in this iteration
		for (ArrayList<Integer> temp : prev) {
			result.add(new ArrayList<Integer>(temp));
		}
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
}
}
