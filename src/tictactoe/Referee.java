package tictactoe;

import Service.BoardService;
import VictoryStrategy.*;

import java.util.ArrayList;
import java.util.List;

import static tictactoe.Tictactoe.printWinner;
import static tictactoe.Tictactoe.printDraw;

interface CheckWinner{
    boolean checkWinner(char playerIdentifier, VictoryStrategies victoryStrategies);
}

class CheckWinnerImpl implements CheckWinner{
    BoardService boardService = Container.getBoardService();
    @Override
    public boolean checkWinner(char playerIdentifier, VictoryStrategies victoryStrategies) {
        for(VictoryStrategy strategy : victoryStrategies.victoryStrategies){
            if(strategy.check(boardService.getBoard(), playerIdentifier)) {
                printWinner(playerIdentifier);
                return true;
            }
        }
        return false;
    }

}

interface CheckDraw{
    boolean checkDraw();
}

class CheckDrawImpl implements CheckDraw {
    BoardService boardService = Container.getBoardService();
    @Override
    public boolean checkDraw() {
        if (!boardService.checkLeftSpaceExist()) {
            printDraw();
            return true;
        }
        return false;
    }
}

class VictoryStrategies{
    List<VictoryStrategy> victoryStrategies = new ArrayList<>();
    VictoryStrategies(int row, int col){
        victoryStrategies.add(new StrategyRow(row, col));
        victoryStrategies.add(new StrategyCol(row, col));
        victoryStrategies.add(new StrategyNorthEastDiagonal(row, col));
        victoryStrategies.add(new StrategySouthEastDiagonal(row, col));
    }
}

public class Referee {
    CheckWinner checkWinner = new CheckWinnerImpl();
    CheckDraw checkDraw = new CheckDrawImpl();
    VictoryStrategies victoryStrategies;
    public Referee(int row, int col){
        this.victoryStrategies = new VictoryStrategies(row, col);
    }
    public boolean checkContinue(char playerIdentifier) {
        if(checkWinner.checkWinner(playerIdentifier, victoryStrategies)) return false;
        if(checkDraw.checkDraw()) return false;
        return true;
    }
}