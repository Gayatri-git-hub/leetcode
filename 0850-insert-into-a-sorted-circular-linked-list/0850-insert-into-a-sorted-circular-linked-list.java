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
        Node newNode = new Node(insertVal);
        
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        } 

        Node origHead = head;

        Node prev = head;
        Node curr = head.next;

        do{
           if(newNode.val >= prev.val && newNode.val <= curr.val){
               prev.next = newNode;
               newNode.next = curr; 
               return origHead;
           }     
           else if (curr.val < prev.val) { //this means we passed on from Tail to head now
            if (newNode.val > prev.val || newNode.val < curr.val) {
                prev.next = newNode;
                newNode.next = curr; 
                return origHead;
            }

           }
           
           prev = curr;
           curr = curr.next; 
           

        } while(prev != head);

        Node temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;
        return origHead;
    }
}