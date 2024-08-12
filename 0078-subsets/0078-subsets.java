class Solution {
    List<List<Integer>> results = new ArrayList<>();
    int setLen;
    
    private void backtrack(int start, int[] nums, ArrayList<Integer> currSubset){

        if(currSubset.size() == setLen) {
            results.add(new ArrayList<Integer>(currSubset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currSubset.add(nums[i]);

            backtrack(i+1, nums, currSubset);

            currSubset.remove(currSubset.size() -1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        if(nums.length == 0) return results;

        for (setLen = 0; setLen <= nums.length; setLen++) {
            backtrack(0, nums, new ArrayList<Integer>());
            
        } 

        return results;
    }
}