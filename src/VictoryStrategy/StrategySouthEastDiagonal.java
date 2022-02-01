package VictoryStrategy;


public class StrategySouthEastDiagonal extends VictoryStrategy {
    public StrategySouthEastDiagonal(int row, int col) {
        super(row, col);
    }

    /**
     * 0,0 -> 2,2
     *
     * @param board
     * @param playerIdentifier
     * @return
     */
    @Override
    public boolean check(char[][] board, char playerIdentifier) {
        int dx = +1, dy = +1;
        int x = 0, y = 0;
        for (int i = 0; i < this.row && i < this.col; i++) {
            if (board[x][y] != playerIdentifier)
                return false;
            x += dx;
            y += dy;
        }
        return true;
    }
}