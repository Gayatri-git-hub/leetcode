from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        my_set = set()
        for n in nums:
            if n in my_set:
                return True 
            else:
                my_set.add(n)
        
        return False
        