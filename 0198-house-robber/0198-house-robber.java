class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    private int dp(int[] nums, int  i){
        if(i == 0) return nums[i];
        if(i == 1) return Math.max(nums[i], nums[i-1]);
        if(!memo.containsKey(i)) memo.put(i, Math.max(dp(nums, i-1), dp(nums, i-2) + nums[i]));

        return memo.get(i);
    }
    public int rob(int[] nums) {
        // Dynamic Programming Problem

        //Approach 1) Top-Down Using memoization
        //return dp(nums, nums.length-1);
        
        //Approach 2) Bottom-up using Iterator
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dpArr = new int[nums.length];
        
        dpArr[0] = nums[0];
        dpArr[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            dpArr[i] = Math.max(dpArr[i-1], dpArr[i-2] + nums[i]);
        }

        return dpArr[nums.length-1];
    }
}