package VictoryStrategy;

public class StrategyCol extends VictoryStrategy{
    public StrategyCol(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean check(char[][] board, char playerIdentifier) {
        boolean flag;
        for (int i = 0; i < this.col; i++) {
            flag = true;
            for (int j = 0; j < this.row; j++) {
                if (board[j][i] != playerIdentifier) {
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }

}
