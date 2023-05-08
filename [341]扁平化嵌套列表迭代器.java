//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	//迭代器
	private Iterator<Integer> it;


	public NestedIterator(List<NestedInteger> nestedList) {
		List<Integer> res = new ArrayList<>();

		for (NestedInteger iterator : nestedList) {
			traverse(iterator, res);
		}

		this.it = res.iterator();
	}

	@Override
	public Integer next() {
		return it.next();
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	public void traverse(NestedInteger iterator, List<Integer> res) {
		//如果是叶子节点
		if (iterator.isInteger()) {
			res.add(iterator.getInteger());
			return;
		}

		for (NestedInteger temp : iterator.getList()) {
			traverse(temp, res);
		}

	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
