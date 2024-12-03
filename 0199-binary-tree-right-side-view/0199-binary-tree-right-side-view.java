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
    List<Integer> ans = new LinkedList<>();

    private void dfs(TreeNode node,int level){
        if(node == null) return;

        if(level == ans.size()) ans.add(node.val);

        dfs(node.right, level + 1);
        dfs(node.left, level + 1);

    }
    public List<Integer> rightSideView(TreeNode root) {

        //Approach 1) using BFS -Which I feel good
        return bfs(root);

        //Approach 2) using DFS 
        //dfs(root, 0);
        //return new ArrayList<>(ans);
    }

    private List<Integer> bfs(TreeNode root){
        Queue<Pair<Integer, TreeNode>> que = new LinkedList<>();

        que.offer(new Pair<Integer, TreeNode>(0, root));

        Map<Integer, Integer> result = new HashMap<>();

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Pair<Integer, TreeNode> item = que.poll();
                TreeNode node = item.getValue();
                Integer level = item.getKey();

                if(node != null){
                    if(!result.containsKey(level))
                        result.put(level, node.val);
                    
                    que.offer(new Pair<Integer, TreeNode>(level + 1, node.right));
                    que.offer(new Pair<Integer, TreeNode>(level + 1, node.left));
                } 
                
            }            
        }
        return new ArrayList<>(result.values());
    }
}