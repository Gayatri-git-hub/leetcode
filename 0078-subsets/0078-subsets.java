class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>());

        return res;  
    }

    private void backtrack(int[] nums, int index, ArrayList curr){

        res.add(new ArrayList(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, i+1, curr);
            curr.remove(curr.size()-1);
        }

        return;
    }

}