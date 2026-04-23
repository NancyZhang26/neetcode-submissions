class Solution {
    int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, seen, i, j, 0)) return true;
                }
            }
        }

        return false;
        
    }

    public boolean dfs(char[][] board, String word, boolean[][] seen, int row, int col, int index) {    
        if (index == word.length()) {
            System.out.println("Done");
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            System.out.println("Out of bounds");
            return false;
        }

        if (seen[row][col]) {
            System.out.println("Seen it before");
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            System.out.println("Wrong char");
            return false;
        }

        seen[row][col] = true;

        for (int[] dir: DIRS) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (dfs(board, word, seen, r, c, index+1)) return true;
        }

        seen[row][col] = false;

        return false;
    }
}
