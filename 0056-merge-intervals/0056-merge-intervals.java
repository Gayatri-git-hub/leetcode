class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> results = new LinkedList<>();

        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        for (int[] iv : intervals) {
            if(results.isEmpty()) results.add(iv);
            else {

                int[] lastEle = results.getLast();

                if(lastEle[1] > iv[0] || iv[0] <= lastEle[1]){
                    lastEle[0] = Math.min(iv[0], lastEle[0]);
                    lastEle[1] = Math.max(iv[1], lastEle[1]);
                }
                else
                    results.add(iv);                            
            }
        }


        return results.toArray(new int[results.size()][2]);
    }
}