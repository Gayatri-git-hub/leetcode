class Solution {
    public int singleNumber(int[] nums) {
        //non empty array - boundry check []
        //linear runtime complexity
        //constant extra space
        int a =0;
       for(int i: nums){
            a ^= i;
       }

        return a;
    }
}