class Solution {
    public double myPow(double x, int n) {
        //when n==0
        //when n==1
        //when n is -ve
        //when n is odd

        return binaryExpo(x, (long) n);
    }

    private double binaryExpo(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;

        if(n < 0) return 1/binaryExpo(x, -n);

        if (n % 2 == 0) 
            return binaryExpo(x*x, n/2);
        else
            return x * binaryExpo(x*x, (n-1)/2);
    }
}