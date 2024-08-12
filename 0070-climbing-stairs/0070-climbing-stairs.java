class Solution {

    private int calcSteps(int start, int steps, int[] memo){

        if (start > steps) return 0;
        if (start == steps) return 1;

        if (!(memo[start] >0)) 
            memo[start] = calcSteps(start+1, steps, memo) + calcSteps(start+2, steps, memo);
        
        return memo[start];

    } 

    public int climbStairs(int n) {

        int[] memo = new int[n];    

        return calcSteps(0, n, memo);
   
        
    }
}