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
        Node newHead;

        Map<Node, Node> nodeMap= new HashMap<>();
        

        while (origHead != null) {
            Node cloneNode = new Node(origHead.val);
            
            nodeMap.put(origHead, cloneNode);

            origHead = origHead.next;           
        }
        
        origHead = head;
        while (origHead != null) {
            Node cloNode = nodeMap.get(origHead);
            cloNode.next = nodeMap.get(origHead.next);
            cloNode.random = nodeMap.get(origHead.random);

            origHead = origHead.next;
        }

        return nodeMap.get(head);
    }
}