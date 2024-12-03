class Cell{
    int val;
    int row;
    int col;
    int dist;

    public Cell(int v, int r, int c, int d){
        val = v;
        row = r;
        col = c;
        dist =d;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        Queue<Cell> que = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        que.offer(new Cell(grid[0][0], 0, 0, 1));

        while (!que.isEmpty()) {
            Cell c = que.poll();

            visited[c.row][c.col] = true;

            if(c.val == 1) continue;

            if (c.row == m-1 && c.col == n-1) return c.dist;

            for (int[] cell : getCellNeighbours(c)) {
                int i = cell[0];
                int j = cell[1];
                if ((i >= m) || (i < 0 ) || (j >= n) || (j < 0) || visited[i][j]) continue;
                
                visited[i][j] = true;
                
                que.add(new Cell(grid[i][j], i, j, c.dist + 1));
            }
        }
        
        return -1;
    }

    private List<int[]> getCellNeighbours(Cell c){
        List<int[]> results = new LinkedList<>();

        results.add(new int[]{c.row -1,c.col-1});
        results.add(new int[]{c.row -1,c.col});
        results.add(new int[]{c.row -1,c.col+1});

        results.add(new int[]{c.row,c.col-1});
        results.add(new int[]{c.row,c.col+1});

        results.add(new int[]{c.row +1,c.col-1});
        results.add(new int[]{c.row +1,c.col});
        results.add(new int[]{c.row +1,c.col+1});

        return results;
    }
}