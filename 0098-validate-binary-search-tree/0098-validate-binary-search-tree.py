# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def helper(lower, node, upper) -> bool:

            if not node:
                return True
            
            if not (lower < node.val < upper):
                return False
            
            return helper(lower, node.left, node.val) and helper(node.val, node.right, upper)
  
            
            
        return helper(float('-inf'), root, float('inf'))
        

        
        