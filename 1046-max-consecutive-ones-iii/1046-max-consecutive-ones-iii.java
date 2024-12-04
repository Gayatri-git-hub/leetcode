class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxWinSize =0;
        int left = 0;
        int zeroCtr = 0;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroCtr++;

            while (zeroCtr > k) {
                if(nums[left] == 0) zeroCtr--;
                left++;
            }
            
            maxWinSize = Math.max(maxWinSize, (right - left) + 1);
        }
        return maxWinSize;
    }
}