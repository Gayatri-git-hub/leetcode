/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node origHead = head;
        Map<Node, Node> nodeMap = new HashMap<>();

        while (origHead != null) {
            nodeMap.put(origHead, new Node(origHead.val));
            origHead = origHead.next;            
        }

        origHead = head;
        while (origHead != null) {
            Node clone = nodeMap.get(origHead);
            clone.next = nodeMap.get(origHead.next);
            clone.random = nodeMap.get(origHead.random);

            origHead = origHead.next;
        }

        return nodeMap.get(head);
        
    }
}