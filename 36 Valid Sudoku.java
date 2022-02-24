/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Ex:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if (board[i][j]!='.')
                {
                    //check row and col constraints across the entire board
                    for(int k = 0; k<9; k++)
                    {
                        if((board[i][j]==board[i][k] && k!=j) || (board[i][j]==board[k][j] && i!=k))
                        {
                            return false;
                        }    
                    }
                
                    //check box constraint
                    int rowStart = (i/3)*3;
                    int colStart = (j/3)*3;
                    for (int a = rowStart; a<rowStart+3; a++)
                    {
                        for (int b = colStart; b<colStart+3; b++)
                        {
                            if (board[i][j] == board[a][b] && (i!=a && j!=b))
                            {
                                return false;
                            }
                        }
                    } 
                }
            }
        }
        return true;
    }
}
