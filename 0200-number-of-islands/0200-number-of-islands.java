class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{-1,0},{1,0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int numOfIslands =0;
        
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') numOfIslands += 1;

                setSurroundingsZero(grid, i, j);

            }
        }

        return numOfIslands;
    }

    private void setSurroundingsZero(char[][] grid, int i, int j){
        if(0 <= i && i <m && 0<= j && j < n && grid[i][j] == '1') 
            grid[i][j] ='0';
        else
            return;
            
        for (int[] dir : directions) {
            setSurroundingsZero(grid, i + dir[0], j + dir[1]);
        }
        return;
    }
}