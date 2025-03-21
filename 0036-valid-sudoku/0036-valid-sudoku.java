class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int rowMask = 0, colMask = 0, boxMask = 0;
            
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if ((rowMask & (1 << num)) != 0) return false;
                    rowMask |= (1 << num);
                }
                
                // Check column
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if ((colMask & (1 << num)) != 0) return false;
                    colMask |= (1 << num);
                }
                
                // Check 3x3 sub-box
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.') {
                    int num = board[rowIndex][colIndex] - '1';
                    if ((boxMask & (1 << num)) != 0) return false;
                    boxMask |= (1 << num);
                }
            }
        }
        return true;
    }
}