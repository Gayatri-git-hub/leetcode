class Solution {
    
    private int recFibo(int n, int acc){

        if(n == 0) return 0;
        if(n == 1) return 1;

        return recFibo(n-1, acc + n) + recFibo(n -2, acc);
    }
   
    public int fib(int n) {
        return recFibo(n, 0);
    }
}