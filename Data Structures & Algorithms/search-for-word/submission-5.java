class Solution {
    int[][] DIRS = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] u = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, u, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] used, String word, int index, int row, int col) {
        
        if (index == word.length()) return true;
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) return false;

        if (used[row][col]) return false;

        if (board[row][col] != word.charAt(index)) return false;

        used[row][col] = true;

        for (int[] dir: DIRS) {
            int r = row+dir[0];
            int c = col+dir[1];

            if (dfs(board, used, word, index+1, r, c)) return true;
        }

        used[row][col] = false;

        return false;
    }
}
