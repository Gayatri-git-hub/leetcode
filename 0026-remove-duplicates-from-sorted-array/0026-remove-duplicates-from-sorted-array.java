class Solution {
    public int removeDuplicates(int[] nums) {

       int newIdx=0; 
       for (int i = 0; i < nums.length; i++) {
            if(i == 0) nums[newIdx++] = nums[i];
            else if (nums[i] == nums[i-1]) continue;
            else nums[newIdx++] = nums[i];
       }

       return newIdx;
    }
}