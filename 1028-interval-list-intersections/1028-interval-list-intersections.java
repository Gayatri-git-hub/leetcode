class Interval{
    int start;
    int end;
    public Interval(int s,int e){
        start = s;
        end = e;
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<Interval> res = new ArrayList<>();

        int i=0;
        int j=0;
        
        while (i < firstList.length && j < secondList.length) {
            Interval first = new Interval(firstList[i][0], firstList[i][1]);
            Interval second = new Interval(secondList[j][0], secondList[j][1]);

            if(first.start > second.end) {
                j++;
                continue;
            }

            if(second.start > first.end) {
                i++;
                continue;
            }

            Interval intersect = new Interval(Math.max(first.start, second.start),
             Math.min(first.end, second.end));

            res.add(intersect);

            if (first.end > second.end) j++;
            else i++;
        }

        int[][] ans = new int[res.size()][2];
        for(int a=0; a< res.size(); a++){
            ans[a] = new int[]{res.get(a).start, res.get(a).end};
        }

        return ans;

    }
}