/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = null;
        int carryOver=0;
        int val =-1;

        ListNode result = null;
        
        while(l1 != null || l2 != null){

            int val1 = (l1 ==null) ? 0: l1.val;
            int val2 = (l2 == null) ? 0: l2.val;

            int sum = val1 + val2 + carryOver;

            if (sum >= 10) {
                carryOver = 1;
                sum = sum % 10;
            } else
            carryOver =0;
       
            
            ListNode nl = new ListNode(sum);

            if(head == null) {
                head = nl;
                result = head;
            }
            else{
                    head.next = nl;
                    head= head.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carryOver == 1){
            ListNode nl = new ListNode(1);
            head.next = nl;
        }
            
        return result;
    }
}