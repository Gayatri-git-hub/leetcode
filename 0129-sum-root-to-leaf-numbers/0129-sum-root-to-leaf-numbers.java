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

    int sum;
    private void dfs(TreeNode node, String num){

        if(node.left == null && node.right == null) {
            System.out.println("Returning from Node: " + node.val);

            int rootToLeaf = Integer.parseInt(num + node.val);
            System.out.println("Integer Root to Leaf: " + rootToLeaf);
            sum += rootToLeaf ;

            System.out.println("Calculated Sum: " + sum);
            return;
        }


        if(node.left != null) dfs(node.left, num + node.val);
        if(node.right != null) dfs(node.right, num + node.val);


    }

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }
}