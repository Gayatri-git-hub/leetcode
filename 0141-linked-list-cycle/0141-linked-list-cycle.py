# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # Option 1) Using visited Hash Table

        my_dict = {}

        while head:
            if head in my_dict:
                return True
            
            my_dict[head] = head
            head = head.next
        
        return False
        