class Solution {
    public int rob(int[] nums) {
        
        int[] sum = new int[nums.length];
        for(int i= 0; i< nums.length; i++)  {
            if(i==0) {
                sum[i]=nums[i];
            }else if(i ==1) {
                sum[i] = Math.max(nums[i], sum[i-1]);
            }else   {
                sum[i]=sum[i-2]+nums[i];
                if(sum[i] < sum[i-1]) {
                    sum[i]=sum[i-1];
                }
            }
        }
        return sum[nums.length - 1];
    }
}