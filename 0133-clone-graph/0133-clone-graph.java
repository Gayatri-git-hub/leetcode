/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> que = new LinkedList<>();
        Map<Node, Node> nodeMap = new HashMap<>();

        que.offer(node);

        while (!que.isEmpty()) {
            
            int size =que.size();
            for (int i = 0; i < size; i++) {
                Node n = que.poll();
                Node clone = new Node(n.val);
                nodeMap.put(n, clone);

                for (Node ne : n.neighbors) {
                    if(!nodeMap.containsKey(ne))
                        que.offer(ne);    
                }
                
            }
        }

        for (Node n : nodeMap.keySet()) {
            Node clone = nodeMap.get(n);
            for (Node ne : n.neighbors) {
                clone.neighbors.add(nodeMap.get(ne));
            }
        }

        return nodeMap.get(node);
        
    }
}