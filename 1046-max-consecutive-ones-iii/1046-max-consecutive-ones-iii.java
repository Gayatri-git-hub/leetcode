class Solution {
    public int longestOnes(int[] nums, int k) {

        int maxWin =0;
        int zeroCounter =0;
        int left =0;
       
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCounter ++;
            
            if(zeroCounter > k) {
                while (zeroCounter > k) {
                    if(nums[left] == 0) zeroCounter--;
                    left++;
                }
            }

            maxWin = Math.max(maxWin, (right -left)+1);
        }

        return maxWin;
        
    }
}