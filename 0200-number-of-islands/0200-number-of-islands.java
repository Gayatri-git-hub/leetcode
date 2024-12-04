class Solution {
    int m;
    int n;
    int[][] dirs = new int[][]{{-1,0}, {1,0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int numOfIslands=0;
        m= grid.length;
        n =grid[0].length;

           for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') 
                        numOfIslands += 1;
                    
                    setSurroundingsToZero(grid, i, j);
                } 
           } 
        return numOfIslands;
    }

    private void setSurroundingsToZero(char[][] grid, int i, int j){
        if(0 <= i && i < m && 0 <= j && j < n && grid[i][j] == '1')
            grid[i][j] = '0';
        else
            return;
        
        for (int[] d : dirs) 
            setSurroundingsToZero(grid, i + d[0], j + d[1]);
        
        return;
    }
}