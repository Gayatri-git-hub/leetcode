# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:

        # Option 2) Better for Space complxity O(1)
        # Floyd's Cycle detection : Fast & Slow Pointers

        if head is None or head.next is None:
            return False
        
        slow = head
        fast = head.next

        while slow != fast:
            if fast is None or fast.next is None:
                return False
            slow = slow.next
            fast = fast.next.next

        return True

        # Option 1) Using visited Hash Table 
        # Time Complexity = O(N) and Space Complexity = O(N)

        my_dict = {}

        while head:
            if head in my_dict:
                return True
            
            my_dict[head] = head
            head = head.next
        
        return False
        