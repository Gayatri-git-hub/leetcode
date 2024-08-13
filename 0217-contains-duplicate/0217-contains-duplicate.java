class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> vals = new HashSet<>();

        for(int i =0; i < nums.length; i++){
            if(!vals.contains(nums[i])) vals.add(nums[i]);
            else return true;
        }
        return false;
    }
}