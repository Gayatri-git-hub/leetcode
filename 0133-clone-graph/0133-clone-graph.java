
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

        if (node == null)  return null;

        Deque<Node> que = new ArrayDeque<>();
        Map<Node, Node> clone = new HashMap<>();
        Node origHead = node;

        que.add(node);
        clone.put(node, new Node(node.val));
       
        while (!que.isEmpty()) {
            Node old = que.poll();
            Node newN = clone.get(old);

            for (Node ne : old.neighbors) { 
                if (!clone.containsKey(ne)) {
                    clone.put(ne, new Node(ne.val));
                    que.add(ne);
                }
                newN.neighbors.add(clone.get(ne));
            }
            
        }

        return clone.get(origHead);
    }

}