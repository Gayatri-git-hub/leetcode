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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        Integer minCol=0;
        Integer maxCol = 0;

        if(root == null) return res;
        
        Queue<Pair<Integer, TreeNode>> que = new LinkedList(); 

        que.offer(new Pair(0, root));

        while(!que.isEmpty()){

            Pair<Integer, TreeNode> curr = que.poll();  
            TreeNode node =curr.getValue();
            Integer colIdx = curr.getKey();

            if(node != null){
                if(!map.containsKey(colIdx))
                    map.put(colIdx, new ArrayList<>());

                map.get(colIdx).add(node.val);
                que.add(new Pair(colIdx - 1, node.left));
                que.add(new Pair(colIdx + 1, node.right));
                
                minCol= Math.min(minCol, colIdx);
                maxCol= Math.max(maxCol, colIdx);
            }
        }
        for(Integer i=minCol; i<= maxCol; i++){
            res.add(map.get(i));
        }
        return res;
    }
}