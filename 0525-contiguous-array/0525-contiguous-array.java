class Solution {
    public int findMaxLength(int[] nums) {
        //  count,   index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int maxLen =0;
        int counter=0;
        for (int i = 0; i < nums.length; i++) {
            counter = counter + (nums[i] == 1? 1:-1);

            if(map.containsKey(counter))
                maxLen = Math.max(maxLen, i - map.get(counter));
            else
                map.put(counter, i);    
        }
        return maxLen;
    }
}