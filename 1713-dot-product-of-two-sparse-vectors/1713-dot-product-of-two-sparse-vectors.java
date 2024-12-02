class SparseVector {
    Map<Integer, Integer> inducesWithOne = new HashMap();
    SparseVector(int[] nums) {
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0)
                inducesWithOne.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum=0;
        
        if (inducesWithOne == null) return sum;
        Set<Integer> ks = inducesWithOne.keySet();
        ks.retainAll(vec.inducesWithOne.keySet());
        for (Integer idx : ks) {
            sum += inducesWithOne.get(idx)* vec.inducesWithOne.get(idx);
        }
        
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);