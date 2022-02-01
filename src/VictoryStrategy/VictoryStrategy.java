package VictoryStrategy;

public abstract class VictoryStrategy {
    int col, row;
    public abstract boolean check(char[][] board, char playerIdentifier);
    public VictoryStrategy(int row, int col){
        this.col = col;
        this.row = row;
    }
}
