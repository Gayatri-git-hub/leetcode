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

        int left = dfs(node.left, p, q) ? 1:0;
        int right = dfs(node.right, p, q) ? 1:0;
        int mid = (node == p || node == q) ? 1:0;

        if((left + right + mid) == 2) {
            ans = node;
            return true;
        }

        if((left + right + mid) > 0) return true;

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p,q);
        return ans;
                
    }
}