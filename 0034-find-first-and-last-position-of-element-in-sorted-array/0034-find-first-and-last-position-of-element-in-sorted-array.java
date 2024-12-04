class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 1 && target == nums[0]) return new int[]{0,0};
        
        if (nums.length == 2) {
            
        }

        int left =0;
        int right = nums.length-1;
        
        while (left <= right) { // Note = used
            int mid;
            mid = (left + right)/2;     //Note: calculation

            if(nums[mid] == target){
                int first = mid;
                while (first >0 && nums[first] == nums[first-1]) {
                    first--;
                }
                int last = mid;
                while (last < nums.length-1 && nums[last] == nums[last + 1]) {
                    last++;
                }
                return new int[]{first, last};
            }

            if (nums[mid] < target) left =mid + 1;
            else right = mid -1; 
        }
        return new int[]{-1, -1};
    }
}