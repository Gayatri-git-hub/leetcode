/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;

        
        boolean leftNode = dfs(node.left, p, q);
        boolean righttNode = dfs(node.right, p, q);

        boolean isNodeItself = (node == p || node == q);

        if(((leftNode ? 1:0) + (righttNode? 1:0) + (isNodeItself ? 1:0)) == 2) {
            ans = node;
            return true;
        }

        if (leftNode || righttNode || isNodeItself) return true;
  
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      dfs(root, p, q);
      return ans;
    }
}
