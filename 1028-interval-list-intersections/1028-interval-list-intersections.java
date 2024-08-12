class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int ptr1 = 0;
        int ptr2 = 0;
        ArrayList<int[]> results = new ArrayList<>();

        while (ptr1 < firstList.length && ptr2 < secondList.length) {
            
            int low = Math.max(firstList[ptr1][0], secondList[ptr2][0]);
            int hi = Math.min(firstList[ptr1][1], secondList[ptr2][1]);

            if(low <= hi)
                results.add(new int[]{low, hi});

            if(firstList[ptr1][1] <  secondList[ptr2][1]) ptr1++;
            else ptr2++;   
        }

        int[][] res = new int[results.size()][2];

        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }

        return res;
    }
}