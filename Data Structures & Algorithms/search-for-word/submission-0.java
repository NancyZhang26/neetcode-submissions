class Solution {
    int[][] DIRS = {{1,0}, {0,1}, {0,-1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int co = board[0].length;

        boolean[][] used = new boolean[r][co];
        int index = 0;

       char c = word.charAt(index);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) {
                    index++;
                    used[i][j] = true;
                    if (dfs(board, used, i, j, index, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean[][] used, int row, int col, int index, String word) {
        int rowL = board.length;
        int colL = board[0].length;

        if (index==word.length()) return true;

        char c = word.charAt(index);

        for (int[] dir: DIRS) {
            int rowNum = row+dir[0];
            int colNum = col+dir[1];

            if (rowNum >= rowL || colNum >= colL || rowNum < 0 || colNum < 0 || used[rowNum][colNum] || board[rowNum][colNum]!=c) {
                continue;
            }

            used[rowNum][colNum] = true;

            if (!dfs(board, used, rowNum, colNum, index+1, word)) {
                used[rowNum][colNum] = false;
                continue;
            } else {
                return true;
            }
        }

        return false;
    }
}


/**

if you find one matching word
you go from that word, try four directions
if you can't find any of the next word, return false
if you can find a next word within the four choices, go on, try the next letter
if the maze finishes before the word reaches the end, return false;


*/
