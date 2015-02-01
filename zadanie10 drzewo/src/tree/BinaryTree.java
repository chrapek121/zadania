package tree;

public class BinaryTree {

	private Node root;

	public boolean add(int value) {
		boolean flag = false;

		if (root == null) {
			root = new Node(value);
			flag = true;
		}

		if (value == root.value) {
			flag = false;
		}

		if (value > root.value) {
			root = root.rightChild;
			flag = true;
		} else {
			root = root.leftChild;
			flag = true;
		}
		return flag;
	}
}
