class Solution {
    
    int size = 0;
    int maxSize = Integer.MIN_VALUE;
    int[][] DIR = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1) {
                    dfs(grid, i, j);
                    maxSize = Math.max(maxSize, size);
                    size = 0;
                }
            }
        }
        return maxSize==Integer.MIN_VALUE?0:maxSize;
    }

    public void dfs(int[][] grid, int r, int c) {
        grid[r][c] = 0;
        size++;

        for (int[] dir: DIR) {
            int row = r+dir[0];
            int col = c+dir[1];

            if (inRange(grid, row, col) && grid[row][col]==1) {
                dfs(grid, row, col);
            }
        }
    }

    public boolean inRange(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length;
    }
}
