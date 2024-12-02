class SparseVector {
    Set<Integer> inducesWithOne = new HashSet<>();
    int[] numList;
    SparseVector(int[] nums) {
        numList =nums;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0)
                inducesWithOne.add(i);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum=0;
        this.inducesWithOne.retainAll(vec.inducesWithOne);

        if (inducesWithOne == null) return sum;

        for (Integer idx : inducesWithOne) {
            sum += (this.numList[idx] * vec.numList[idx]);
        }
        
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);