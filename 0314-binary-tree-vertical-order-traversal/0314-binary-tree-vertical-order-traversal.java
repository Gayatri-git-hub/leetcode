
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;/**
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

class Node {
    TreeNode node;
    int col;
    int level;

    public Node(TreeNode n, int c, int l){
        node= n;
        col = c;
        level = l;
    }
} 
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;

        Queue<Node> q = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        q.offer(new Node(root, 0, 0));

        while(!q.isEmpty()){

            Node n = q.poll();
            map.computeIfAbsent(n.col, k -> new ArrayList<Integer>()).add(n.node.val);

            if(n.node.left != null)
                q.add(new Node(n.node.left, n.col-1, n.level+1));
            
            if (n.node.right != null) 
                q.add(new Node(n.node.right, n.col+1, n.level+1));
        }

        map.entrySet().stream()
        .sorted((k1, k2) -> k1.getKey().compareTo(k2.getKey()))
        .forEach(es -> results.add(es.getValue()));

        return results;
    }
}