

import static java.lang.Math.random;

class Solution {
    int totalSum =0;
    int[] prefixSum;
    Random rnd;
    public Solution(int[] w) {
        prefixSum = new int [w.length];
        for(int i=0;i<w.length; i++){
            totalSum += w[i]; 
            prefixSum[i] = totalSum;
        }
        rnd = new Random(totalSum);
    }
    
    public int pickIndex() {
        int target = new Random().nextInt(totalSum);

        for(int i=0; i<prefixSum.length; i++){
            if(target < prefixSum[i]) return i;
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */