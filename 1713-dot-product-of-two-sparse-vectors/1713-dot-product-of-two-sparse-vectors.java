class SparseVector {
    //Map<Integer, Integer> inducesWithOne = new HashMap();

    List<int[]> pairs;

    SparseVector(int[] nums) {
        pairs = new ArrayList<>();

        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0)
                pairs.add(new int[]{i,nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum=0;
        
        //Approach 1) Using HashMap - Someitmes Interviewer will not accept and will ask for another solution.
        /*if (inducesWithOne == null) return sum;
        Set<Integer> ks = inducesWithOne.keySet();
        ks.retainAll(vec.inducesWithOne.keySet());
        for (Integer idx : ks) {
            sum += inducesWithOne.get(idx)* vec.inducesWithOne.get(idx);
        }
        */
       int p =0;
       int q=0;

       while (p < this.pairs.size() && q < vec.pairs.size()) {

            int thisIdx = this.pairs.get(p)[0];
            int vecIdx = vec.pairs.get(q)[0];

            if (thisIdx == vecIdx) {
                sum += this.pairs.get(p)[1] * vec.pairs.get(q)[1];

                p++;
                q++;
            }
            else{
                if (thisIdx < vecIdx) p++;
                else q++;
            }
       }

        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);