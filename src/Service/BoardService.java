package Service;

import Domain.Board;
import tictactoe.Container;

public class BoardService {
    private Board board = Container.getBoard();
    public void print(int row, int col){
        System.out.println("  a   b   c ");
        for (int j = 0; j < row; j++) {
            System.out.println("    |   |   ");
            System.out.print(j + 1);
            for (int i = 0; i < col; i++) {
                if (i != col - 1)
                    System.out.print(" " + board.board[j][i] + " |");
                else
                    System.out.println(" " + board.board[j][i] + " ");
            }
            if (j != row - 1) System.out.println(" ___|___|___");
            else System.out.println("    |   |   \n");
        }
    }
    public boolean checkLeftSpaceExist(){
        for (char[] row : board.board) {
            for (char col : row) {
                if (col == '-')
                    return true;
            }
        }
        return false;
    }
    public void newStone(int row, int col, char playerIdentifier){
        this.board.board[row][col] = playerIdentifier;
    }

    public char[][] getBoard() {
        return board.board;
    }
}
