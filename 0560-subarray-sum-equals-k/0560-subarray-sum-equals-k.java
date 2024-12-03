class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefSumMap = new HashMap<>();
        int resCount =0;
        int sum =0;

        prefSumMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;

            resCount += prefSumMap.getOrDefault(diff, 0);
            prefSumMap.put(sum, 1 + prefSumMap.getOrDefault(sum, 0));
        }
        return resCount;
    }
}