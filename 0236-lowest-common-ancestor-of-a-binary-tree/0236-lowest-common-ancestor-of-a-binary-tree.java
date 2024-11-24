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
    TreeNode answer;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        dfs(root, p.val, q.val);
        
        return answer;

    }

    public Boolean dfs(TreeNode node, int p, int q){

        if(node == null) return false;

        int left = dfs(node.left, p, q) == true ? 1: 0;
        int right = dfs(node.right, p, q) == true? 1: 0;

        int mid = (node.val == p || node.val == q) ? 1:0;

        if(left + right + mid >= 2) 
            answer = node;
        
        return (left + right + mid > 0);

    }
}