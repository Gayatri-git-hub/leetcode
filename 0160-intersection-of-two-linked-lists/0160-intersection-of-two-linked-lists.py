# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        # Option 2) using 2 pointers: Time COmplexity:  O(m + n), Space COmplexity: O(1) 
        ptr1 = headA
        ptr2 = headB

        while ptr1 != ptr2:
             ptr1 = ptr1.next if ptr1 else headB        #Note else part.
             ptr2 = ptr2.next if ptr2 else headA

        return ptr1   




        # Option 1) using set: Time COmplexity:  O(m + n), Space COmplexity: O(m) or O(n)   

        s = set()
        
        while headA:
            s.add(headA)
            headA = headA.next
        
        while headB:        
            if headB in s:
                return headB
            else:
                headB = headB.next
        
        return None