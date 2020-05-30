/**
 *In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins
 */

public class Main {

      public static class TreeNode {
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

  public static int getDepth(TreeNode node, int data, int depth){
          //base case
          if (node == null)
              return 0;

          if (node.val == data)
              return depth;

          int newDepth = getDepth(node.left, data, depth + 1);
          if (newDepth != 0)
              return newDepth;

          newDepth = getDepth(node.right, data, depth + 1);
          return newDepth;
  }

    public static boolean isSibling(TreeNode node, TreeNode a, TreeNode b) {
        //base case
        if (node == null)
            return false;

        return ((node.left == a && node.right == b) ||
                (node.left == b && node.right == a) ||
                isSibling(node.left, a, b) ||
                isSibling(node.right, a, b));
    }

    public static TreeNode find(TreeNode cur,int val) {

        TreeNode result = null;
        if (cur.left != null)
            result = find(cur.left, val);


        if (cur.val == val)
            return cur;
        if (result == null && cur.right != null)
            result = find(cur.right, val);

        return result;
    }



    public static boolean isCousins(TreeNode root, int x, int y) {
        int depth1, depth2, parent1, parent2;
        depth1 = getDepth(root, x, 1);
        depth2 = getDepth(root, y, 1);
        TreeNode node1 = find(root,x);
        TreeNode node2 = find(root,y);

        if(depth1 == depth2 && !isSibling(root, node1, node2))
            return true;
        else return false;
    }

    public static void main(String []args){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(isCousins(node,2,3));

    }
}
