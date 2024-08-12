class Solution {

    private int calcSteps(int start, int n, int[] memo){

        if(start > n) return 0;
        if(start == n) return 1;

        if(memo[start] > 0) return memo[start];
        
        memo[start] = calcSteps(start+1, n, memo) + calcSteps(start+2, n, memo);
        
        return memo[start];
    }
   
    public int climbStairs(int n) {

        int memo[] = new int[n];

        return calcSteps(0, n, memo);
        
    }
}