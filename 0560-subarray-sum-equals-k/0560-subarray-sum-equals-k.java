class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> prefixSumMap = new HashMap<>();

        prefixSumMap.put(0, 1);
        int sum =0;
        int result =0;  //store the counts

        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];

            int diff = sum - k;
            result += prefixSumMap.getOrDefault(diff, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}