class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int pivotIdx=-1;

        for (int i = n-1; i > 0; i--) {
            if(nums[i] > nums[i-1]){
                pivotIdx = i-1;
                break;
            }
        }

        if(pivotIdx >=0){
            for (int i = n-1; i >=0; i--) {
                if(nums[i] > nums[pivotIdx]){
                    swap(nums, pivotIdx, i);
                    break;
                }
            }
        }
        reverse(nums, pivotIdx+1, n-1);
    }
    private void reverse(int[] nums, int i,int j){
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }
}