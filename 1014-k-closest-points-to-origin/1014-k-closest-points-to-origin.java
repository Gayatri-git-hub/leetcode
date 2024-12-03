class Point{
    int x;
    int y;
    int dist;

    public Point(int x1, int y1, int d){
        x= x1;
        y=y1;
        dist = d;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.dist - p1.dist);

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][01];
            int d = x*x + y*y;

            maxHeap.offer(new Point(x, y, d));

            if (maxHeap.size() > k) maxHeap.poll();
        }
        int[][] ans = new int[maxHeap.size()][2]; 

        for (int i = 0; i < k; i++) {
           Point p =maxHeap.poll();
           ans[i][0] = p.x;
           ans[i][1] = p.y;
        }

        return ans;       
    }
}