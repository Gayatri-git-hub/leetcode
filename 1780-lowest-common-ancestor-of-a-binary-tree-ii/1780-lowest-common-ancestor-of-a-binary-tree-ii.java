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
   TreeNode res;

   private boolean dfs(TreeNode node, TreeNode p, TreeNode q){

        if (node == null) return false;

        int left = dfs(node.left, p, q) ? 1: 0;
        int right = dfs(node.right, p, q) ? 1: 0;
        int root = (node == p || node == q) ? 1: 0;

        if ((left + right + root) == 2) {
            res = node;
            return true;
        }

        return (left ==1 || right == 1 || root ==1);

   }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);

        return res;
        
    }
}