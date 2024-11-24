class Point implements Comparable<Point>{
    int x;
    int y;
    int dist;

   public Point(int x1, int y1, int d){
        this.x = x1;
        this.y = y1;
        this.dist= d;
    }

    public int compareTo(Point y){
        return Integer.compare(y.dist, this.dist);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        if(points.length == 0 ) return new int[0][0];

        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>();

        for(int i=0; i< points.length; i++){
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);

            Point p = new Point(points[i][0], points[i][1], dist);

            maxHeap.add(p);
            if(maxHeap.size() > k)
                maxHeap.remove();            
        }
        int[][] res = new int[k][2];

        for(int i= 0; i<k; i++) {
            Point p= maxHeap.poll();
            res[i] = new int[]{p.x, p.y};
        }

        return res;
    }
}