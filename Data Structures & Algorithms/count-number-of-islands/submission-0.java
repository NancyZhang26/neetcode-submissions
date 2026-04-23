class Solution {
    public static final int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid == null) {
            return 0;
        }

        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]=='1') {
                    bfs(grid, Arrays.asList(i, j));
                    // grid[i][j]=='0';
                    islands++;
                }
            }
        }

        return islands;
        
    }

    public void bfs(char[][] grid, List<Integer> pt) {
        HashSet<List<Integer>> visited = new HashSet<>();
        LinkedList<List<Integer>> q = new LinkedList<>();

        q.add(pt);
        visited.add(pt);
        grid[pt.get(0)][pt.get(1)] = '0';

        while (!q.isEmpty()) {
            List<Integer> temp = q.remove();
            for (int[] change: directions) {
                int r = temp.get(0)+change[0];
                int c = temp.get(1)+change[1];
                List<Integer> l = Arrays.asList(r, c);
                if (r>=0 && r<grid.length && c>=0 && c<grid[0].length
                && !visited.contains(l) && grid[l.get(0)][l.get(1)] == '1') {
                    q.add(l);
                    visited.add(l);
                    grid[l.get(0)][l.get(1)] = '0';
                }
            }
        }

    }
}
