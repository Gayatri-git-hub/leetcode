class Solution {
    int[] prefixSum;
    int totalSum=0;
    Random rnd;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        for(int i=0; i< w.length; i++){
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }  
        rnd = new Random();  
    }
    
    public int pickIndex() {
        if (prefixSum.length == 1) return 0;

        int target = rnd.nextInt(totalSum) + 1;

        /*for(int i=0; i< prefixSum.length; i++){
            if (target < prefixSum[i]) return i;
        }*/
        return binSearch(target, prefixSum);

        
    }

    private int binSearch(int target, int[] nums){
        int left =0;
        int right = nums.length;
        
        while (left < right) {
            int mid = (int) (left + (right - left)/2); 
            
            if(target > prefixSum[mid]) left = mid + 1;
            else right =mid;

        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */