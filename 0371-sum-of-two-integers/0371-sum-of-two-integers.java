class Solution {
    public int getSum(int a, int b) {
       
       while (b != 0) {     //When b =0 which means we do not have any carry over and hence stop;
        int temp = (a & b) << 1;    // Store val in a temp as we will change a to new value
        a = (a ^ b);      //This will give us addition without carry over.      
        b = temp;       //this will get carry over calculated which we have to add it back in the sum;
       }

       return a;     //At this point, we wld hv calculated the sum.
    }
}