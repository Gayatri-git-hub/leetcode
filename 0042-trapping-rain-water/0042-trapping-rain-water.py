class Solution:
    def trap(self, height: List[int]) -> int:
        size = len(height)
        max_left, max_right = [0] * size, [0] * size

        max_left[0] = height[0]
        max_right[-1] = height[-1]
        
        for i in range(1, size):
            max_left[i] = max(height[i], max_left[i-1])

        for i in range(size - 2, -1, -1):
            max_right[i] = max(max_right[i+1], height[i])
        
        ans = 0
        for i in range(size):
            ans += min(max_left[i], max_right[i]) - height[i]

        return ans
        