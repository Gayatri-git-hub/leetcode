/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first;
    Node last;

    public Node treeToDoublyList(Node root) {

        if (root == null) return null;

        inorder(root);

        first.left = last;
        last.right = first;

        return first;
    }

    private void inorder(Node node){
        if (node != null) {

            inorder(node.left);

            if (last == null) first = node;
            else {
                node.left = last;
                last.right = node;
            }

            last = node;    
            inorder(node.right);        
        }
    }
}