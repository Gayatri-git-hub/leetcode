class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}

        for i, num in enumerate(nums):
            print("current num: " + str(num) + " index: " + str(i) + " Required Target num: " + str(target - num))
            n = d.get(target - num, -1)
            if (n == -1):
                d[num] = i
                print("Added num: " + str(target - num) + " to the Dictionary")
            else:
                return [n, i]

        return [-1, -1]

        