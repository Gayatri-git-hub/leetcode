/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> s = new HashSet<>();

        if (p.parent == null)  return p;

        if(q.parent == null) return q;

        s.add(p);
        s.add(q);

        while (p.parent != null || q.parent != null) {

            if(p.parent != null){
                if(s.contains(p.parent)) return p.parent;
                else
                    s.add(p.parent);
                
                p = p.parent;
            }

            if (q.parent != null){
                if(s.contains(q.parent)) return q.parent; 
                else
                    s.add(q.parent);
                q = q.parent;
            }   
        }

        return null;
    }
}