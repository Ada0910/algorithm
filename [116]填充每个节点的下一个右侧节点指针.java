//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
	public Node connect(Node root) {
		if(root == null ){
			return root;
		}
		traverse(root.left, root.right);
		return root;
	}


	// 原本的函数可能不适用，构造三叉树
	public void traverse(Node node1, Node node2) {
		//base case
		if (node1 == null || node2 == null) {
			return;
		}

		node1.next = node2;

		traverse(node1.left,node1.right);
		traverse(node2.left,node2.right);
		traverse(node1.right,node2.left);


	}
}
//leetcode submit region end(Prohibit modification and deletion)
