class Solution {
    public double myPow(double x, int n) {
        return binaryExpn(x,(double) n);
    }

    private double binaryExpn(double x, Double n){
        
        if (n == 0 ) return 1;
        if (n == 1) return x;

        if (n < 0) {
           return 1/binaryExpn(x, -n);
        }

        if (n % 2 == 0) {
            return binaryExpn(x*x, n/2);
        }
        else
            return x * binaryExpn(x*x, (n-1)/2);
    }
}