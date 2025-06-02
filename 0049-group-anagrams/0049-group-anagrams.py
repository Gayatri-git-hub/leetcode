from typing import List
#from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)

        for s in strs:
            sorted_str = ''.join(sorted(s))
            map[sorted_str].append(s)
        
        return list(map.values())