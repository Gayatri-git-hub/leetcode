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

        int i=0;
        int j=0;
        List<Interval> res =new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            Interval first = new Interval(firstList[i][0], firstList[i][1]);
            Interval second = new Interval(secondList[j][0], secondList[j][1]);

            if (first.start > second.end ) {
                j++;
                continue;
            }

            if(second.start > first.end){
                i++;
                continue;
            }

            int s = Math.max(first.start, second.start);
            int e =Math.min(first.end, second.end);
            Interval intersect = new Interval(s,e);

            res.add(intersect);

            if (first.end > second.end) j++;
            else i++;
            
        }   
        int[][] ans = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = new int[] {res.get(k).start, res.get(k).end};
        } 

        return ans;
    }
}