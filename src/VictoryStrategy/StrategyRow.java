package VictoryStrategy;

public class StrategyRow extends VictoryStrategy{

    public StrategyRow(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean check(char[][] board, char playerIdentifier) {
        boolean flag;
        for (char[] row : board) {
            flag = true;
            for (char node : row) {
                if (node != playerIdentifier) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}
