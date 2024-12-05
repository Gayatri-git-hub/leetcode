/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode =new Node(insertVal);
            
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }

        Node prev= head;
        Node curr = head.next;
        
        boolean toInsert = false;

        do{
            if(prev.val <= newNode.val && curr.val >= newNode.val){
                toInsert = true;
            }
            else if(prev.val > curr.val)
            {
                if(insertVal >= prev.val || insertVal <= curr.val)
                    toInsert = true;
            }
            else if(prev == curr){
                toInsert = true;
            }

            if (toInsert) {
                prev.next = newNode;
                newNode.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while(prev != head);

        if (prev.val == curr.val) {
            prev.next = newNode;
            newNode.next = curr;
        }

        return head;
    }
}