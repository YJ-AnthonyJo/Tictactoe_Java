package tictactoe;

import Service.BoardService;
import Service.PlayerService;

import java.io.IOException;
import java.io.InputStream;

public class Tictactoe { //IO도 담당.
    private static InputStream in = System.in;
    private static Referee referee = Container.getReferee();
    private static BoardService boardService = Container.getBoardService();
    private static PlayerService playerService = Container.getPlayerService();
    private static int registerPlayers(){// player registration.
        playerService.addPlayer('X');
        playerService.addPlayer('O');
        return 2; // Player 추가 여지 남겨둠.
    }

    private static void get(char playerIdentifier) throws IOException {
        int col = in.read() - 'a';
        int row = in.read() - '1';
        in.read(); //개행제거.
        boardService.newStone(row, col, playerIdentifier);
    }


    public static void printWinner(char playerIdentifier){
        System.out.println(playerIdentifier + "의 승리");
    }
    public static void printDraw() {
        System.out.println("무승부");
    }

    public static void main(String[] args) throws IOException{
        int playerNumber = registerPlayers();
        int playerIndex = 1;
        int row = Container.getRow();
        int col = Container.getCol();
        char playerIdentifier = playerService.getPlayerIdentifierByIndex(playerIndex);

        boardService.print(row, col);
        while (referee.checkContinue(playerIdentifier)) {
            playerIndex = (playerIndex + 1) % playerNumber;
            playerIdentifier = playerService.getPlayerIdentifierByIndex(playerIndex);
            System.out.print("Next Player: " +
                    playerService.getPlayerIdentifierByIndex(playerIndex)+ "\n> ");
            get(playerIdentifier);
            boardService.print(row, col);
        }
    }
}