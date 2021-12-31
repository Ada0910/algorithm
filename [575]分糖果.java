import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int distributeCandies(int[] candyType) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : candyType) {
			set.add(i);
		}
		if(set.size()>=candyType.length/2){
			return candyType.length/2;
		}

		return set.size();


	}
}
//leetcode submit region end(Prohibit modification and deletion)
