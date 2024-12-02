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
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         dfs(root, p.val, q.val);
         return lca;
    }

    private boolean dfs(TreeNode node, int p, int q){

        if(node == null) return false;

       // if(node.val == p || node.val == q) return true;

        int left = dfs(node.left, p, q) ? 1: 0;
        int right = dfs(node.right, p, q) ? 1: 0;
        int mid = (node.val == p || node.val == q)? 1:0;

        if(left + right + mid >= 2) lca = node;

        return (left + right + mid > 0);      

    }
}