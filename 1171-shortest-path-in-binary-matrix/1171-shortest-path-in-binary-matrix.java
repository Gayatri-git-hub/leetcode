class Cell{
    int row;
    int col;
    int val;
    int dist;

    public Cell(int r, int c, int v, int d){
        row = r;
        col = c;
        val = v;
        dist = d;
    }
}
class Solution {
    int[][] neighbouringIndices = new int[][]{
            {-1,-1},{-1, 0},{-1,1}, {0,-1}, {0,1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length; 
        
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> bfsQue =new LinkedList<>();

        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;

        bfsQue.offer(new Cell(0,0, grid[0][0], 1));

        while (!bfsQue.isEmpty()) {
            int size = bfsQue.size();

            for (int i = 0; i < size; i++) {
                Cell curr = bfsQue.poll();

                if(curr.row == m-1 && curr.col == n-1) return curr.dist;

                visited[curr.row][curr.col] = true;
                
                for (int[] is : neighbouringIndices) {
                    int r = curr.row + is[0] ;
                    int c = curr.col + is[1] ;

                    if (r < 0 || r >=m || c <0 || c >= n) continue;

                    if (grid[r][c] == 0 && !visited[r][c]){
                        Cell nbr = new Cell(r, c,  grid[r][c], curr.dist + 1);
                        bfsQue.offer(nbr);
                    }
                   
                    visited[r][c] = true;


                }
            }
        }
        return -1;
    }
}