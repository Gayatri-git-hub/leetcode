class Solution {
    public int findMaxLength(int[] nums) {
        //  count,   index
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);

        int counter =0;
        int maxLen=0;
        for (int i = 0; i < nums.length; i++) {
            counter = counter + (nums[i] == 1? 1: -1);

            if (counts.containsKey(counter)) {
                maxLen = Math.max(maxLen, i - counts.get(counter));
            }
            else
                counts.put(counter, i);
        }

        return maxLen;
        
    }
}