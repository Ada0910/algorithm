

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	//结果列表
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		LinkedList<Integer> onPath = new LinkedList<>();
		traverse(graph, 0, onPath);
		return res;
	}

	//遍历框架
	public void traverse(int[][] graph, int s, LinkedList<Integer> list) {
		list.addLast(s);
		//结束的条件
		int n = graph.length - 1;
		if (n== s) {
			res.add(new LinkedList<>(list));
		}
		
		for (int temp : graph[s]) {
			traverse(graph, temp, list);
		}
		list.removeLast();
	}
}
//leetcode submit region end(Prohibit modification and deletion)
