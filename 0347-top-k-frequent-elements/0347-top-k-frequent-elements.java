class Element{
    int val;
    int freq;

    public Element(int v, int f){
        val = v;
        freq = f;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((e1, e2) -> e1.freq - e2.freq);

        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
           if (hmap.containsKey(nums[i])) {
                hmap.replace(nums[i], hmap.get(nums[i]) + 1); 
           }     
           else 
                hmap.put(nums[i], 1);
        }

        for (Integer key : hmap.keySet()) {
            minHeap.add(new Element(key, hmap.get(key)));

            if (minHeap.size() > k) 
                minHeap.poll();
        }

        int[] result = new int[minHeap.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = minHeap.poll().val;
        }
        
        return result;
    }
}