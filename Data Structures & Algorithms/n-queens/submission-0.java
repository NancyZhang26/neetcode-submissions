class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // Form a board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, n);
        return res;
    }

    public void backtrack(char[][] board, int row, int n) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] c: board) {
                String s = new String(c);
                list.add(s);
            }
            res.add(list);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i, n)) {
                board[row][i] = 'Q';
                backtrack(board, row+1, n);
            } else {
                continue;
            }           
            board[row][i] = '.';
        }
    }

    // You want to check if there is Q in the diagnal, straight above, or straight below
    public boolean isValid(char[][] board, int row, int col, int n) {
        // System.out.println("Debug");
        // for (int i = 0; i < board.length; i++) {
        //     System.out.println(Arrays.toString(board[i]));
        // }

        int r = row-1;
        while (r >= 0) {
            // System.out.println("While r > 0: " + r);
            // System.out.println("While r > 0: c is: " + col);
            if (board[r][col] == 'Q') return false;
            r--;
        }

        r = row-1; int c = col+1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--; c++;
        }
        r = row-1; c = col-1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            } 
            r--; c--;
        }
        return true;
    }
}
