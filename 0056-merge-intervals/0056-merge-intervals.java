class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> results = new LinkedList<int[]>();

        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        for (int[] iv : intervals) {
            if(results.isEmpty()){
                results.add(iv);
                continue;
            }
            Boolean isOverlap = false;
            if(results.getLast()[1] >= iv[0] || iv[0] < results.getLast()[1])
                isOverlap = true;
            
            if(isOverlap){
                results.getLast()[0] = Math.min(iv[0], results.getLast()[0]);
                results.getLast()[1] = Math.max(iv[1], results.getLast()[1]);
            }
            else
                results.add(iv);
        }
        return results.toArray(new int[results.size()][2]);
    }
}