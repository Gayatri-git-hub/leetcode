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
    int ans;
    public int sumNumbers(TreeNode root) {
        dfsPre(root, 0);

        return ans;
    }

    private void dfsPre(TreeNode node, int currSum){
        if(node == null) return;

        currSum = (currSum * 10) + node.val;

        dfsPre(node.left, currSum);
        dfsPre(node.right, currSum);

        if(node.left == null && node.right == null) 
            ans += currSum;

        return;

    }
}