class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length/2;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) +1);
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() > n) return e.getKey();
        }
        return -1;
    }
}