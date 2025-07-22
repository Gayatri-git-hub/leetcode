# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from collections import defaultdict

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        my_dict = defaultdict(ListNode)
        
        while headA:
            my_dict[headA] = headA
            headA = headA.next
        
        while headB:
            
            if headB in my_dict:
                return headB
            else:
                headB = headB.next
        
        return None