/**
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * EXAMPLE -->
 *           In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 *           Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [],
 *           not null.
 */

public class SearchInTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
       }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if(root.val < val)
            return searchBST(root.right,val);
        else
            return searchBST(root.left,val);

    }
}
