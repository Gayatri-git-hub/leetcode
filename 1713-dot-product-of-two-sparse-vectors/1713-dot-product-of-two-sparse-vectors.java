class SparseVector {
    List<Pair<Integer,Integer>> pairs;
    
    SparseVector(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) pairs.add(new Pair(i, nums[i]));
        }

        
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result =0;

        int p=0, q=0;
        while (p < this.pairs.size() && q < vec.pairs.size()) {
           int thisIdx = this.pairs.get(p).getKey();
           int vecIdx =vec.pairs.get(q).getKey();

            if (thisIdx == vecIdx) {
                result += (this.pairs.get(p).getValue() * vec.pairs.get(q).getValue());

                p++;
                q++;
            }
            else{
                if (thisIdx < vecIdx) p++;
                else q++;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);