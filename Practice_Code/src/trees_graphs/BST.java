package trees_graphs;

public class BST {

	// ============================================
	// Use for check if a Tree is Balance
	public static boolean isBalance(TreeNode root) {
		if (root == null)
			return true; // Base Case

		int heightDiff = getHeight(root.left) - getHeight(root.right);

		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalance(root.left) && isBalance(root.right);
		}
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0; // Base Case

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	// ============================================

	// ============================================
	// Better check if a Tree is Balance
	public static int checkHeight(TreeNode root) {
		if (root == null)
			return 0; // Height of 0

		// Check if left is balance
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1; // Not balanced
		}

		// Check if right is balance
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1; // Not balanced
		}

		// Check if current node is balanced
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			// return height
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	// ============================================

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode leave1 = new TreeNode(1);
		TreeNode leave2 = new TreeNode(2);
		TreeNode leave3 = new TreeNode(3);
		TreeNode leave4 = new TreeNode(4);
//		TreeNode leave5 = new TreeNode(5);

		root.left = leave1;
		root.right = leave2;
		leave1.left = leave3;
		leave1.right = leave4;

		System.out.println(isBalanced(root));
		
	}

}
