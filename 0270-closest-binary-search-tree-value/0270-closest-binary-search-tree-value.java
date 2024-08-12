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

class ClosestNode{
    int val;
    double dist;
    public ClosestNode(int v, double d){
        this.val = v;
        this.dist= d;
    }
} 
class Solution {
    ClosestNode closest = new ClosestNode(Integer.MAX_VALUE, Integer.MAX_VALUE);

    private void dfs(TreeNode node, double target){
        if(node == null) return;

        if ((Math.abs(node.val - target) < closest.dist) || (Math.abs(node.val - target) == closest.dist && node.val < closest.val)) {
            closest.dist = Math.abs(node.val - target);
            closest.val = node.val;
        } 
        if(node.val > target) dfs(node.left, target);
        if(node.val < target) dfs(node.right,target);
    }
    
    public int closestValue(TreeNode root, double target) {
       dfs(root, target);
        return closest.val;
    }
}