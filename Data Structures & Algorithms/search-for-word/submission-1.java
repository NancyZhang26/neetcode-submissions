class Solution {
    int[][] DIRS = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] u = new boolean[board.length][board[0].length];
        int index = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(index)) {
                    u[i][j] = true;
                    if (dfs(board, word, index+1, u, i, j)) {
                        return true;
                    } else {
                        u[i][j] = false;
                        continue;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, boolean[][] used, int r, int c) {
        if (index==word.length()) return true;

        for (int[] dir: DIRS) {
            int row = r+dir[0];
            int col = c+dir[1];

            if (row<0 || col<0 || row == board.length || col==board[0].length || used[row][col] || board[row][col]!=word.charAt(index)) {
                continue;
            } else {
                System.out.println(word.charAt(index));
                System.out.println("?");
                used[row][col] = true;
                if (dfs(board, word, index+1, used, row, col)) return true;

                used[row][col] = false;
            }
        }

        return false;
    }
}
