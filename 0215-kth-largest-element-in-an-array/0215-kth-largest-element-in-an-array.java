class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> h = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            h.add(nums[i]);
            if (h.size() > k) {
                h.poll();
            }
        }
        
        return h.poll();
    }
}