

import static java.lang.Math.max;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int longestDiameter = Integer.MIN_VALUE;

    private int dfs(TreeNode node){
        if(node == null) return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        longestDiameter = Math.max(longestDiameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) +1;  
    }

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return longestDiameter;
     
    }
}