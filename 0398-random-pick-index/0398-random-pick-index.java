class Solution {
    Random rdm = new Random();
    int result = -1;
    int[] numbs;

    public Solution(int[] nums) {
        numbs = nums;
    }
    
    public int pick(int target) {
        int counter=0;
        for (int i = 0; i < numbs.length; i++) {
            if(numbs[i] == target){
                counter++;

                if(rdm.nextInt(counter) == counter - 1)
                    result=i;
            }
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */