package Domain;

public class Board {
    public char[][] board;
    public Board(int row, int col){ //판 초기화
        board = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = '-';
            }
        }
    }
}