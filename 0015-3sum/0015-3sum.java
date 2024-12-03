class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> triplets = new HashSet<>();  
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> map= new HashMap<>();  
            
        for (int i = 0; i < nums.length; ++i) if(dups.add(nums[i])) {
            for (int j = i+1; j < nums.length; j++) {
                int compliment = -(nums[i] + nums[j]);
                if (map.containsKey(compliment) && map.get(compliment) == i) {

                    List<Integer> foundTriplet = Arrays.asList(
                        nums[i], nums[j], compliment);

                    Collections.sort(foundTriplet);
                    triplets.add(foundTriplet);
                }
                
                map.put(nums[j], i);
            }
        }

        return new ArrayList<>(triplets);
        
    }
}