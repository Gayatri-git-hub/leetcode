class Solution {
    int[] numbs;
    Random rnd;
    public Solution(int[] nums) {
        rnd = new Random();
        numbs = nums;
    }
    
    public int pick(int target) {
        int counter=0;
        int result = -1;
        for (int i = 0; i < numbs.length; i++) {
            if(numbs[i] == target){
                counter++;
            
                if(rnd.nextInt(counter) == counter -1)
                    result = i;
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