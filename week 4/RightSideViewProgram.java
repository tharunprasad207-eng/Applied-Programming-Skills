import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RightSideViewProgram {

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode node = null;

            for (int i = 0; i < size; i++) {
                node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // The last node in this level is the rightmost node
            result.add(node.val);
        }

        return result;
    }

    public static void main(String[] args) {

        // Example Tree:
        //       1
        //     /   \
        //    2     3
        //     \     \
        //      5     4

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(root);

        System.out.println("Right Side View:");
        System.out.println(result);
    }
}
