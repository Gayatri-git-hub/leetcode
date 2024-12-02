class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();

        Comparator<int[]> c = new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2){
                return a1[0] - a2[0];
            }
        };

        Arrays.sort(intervals, c);

        int[] currInterval = new int[]{intervals[0][0], intervals[0][1]};

        for (int i = 1; i < intervals.length; i++) {
            if(currInterval[1] >= intervals[i][0]){
                
                currInterval = new int[]{Math.min(currInterval[0],intervals[i][0]) , Math.max(currInterval[1], intervals[i][1])};
            }
            else {
                results.add(currInterval);
                currInterval = new int[]{intervals[i][0], intervals[i][1]};
            }
        }

        results.add(currInterval);

        int[][] ints = new int[results.size()][2];
        for(int i=0; i<results.size(); i++){
            ints[i] = results.get(i);
        }
        
        return ints;
    }
}