package tictactoe; //default package는 다른 package에서 import가 불가능하다 -> tictactoe 패키지를 만들어서 해결해주었다.

import Domain.Board;
import Domain.Player;
import Service.BoardService;
import Service.PlayerService;

import java.util.ArrayList;

public class Container {
    private static int row = 3, col = 3; //row, col 지정해주는 부분.
    private static Board board = new Board(row, col);
    private static BoardService boardService = new BoardService();
    private static PlayerService playerService = new PlayerService();
    private static Referee referee = new Referee(row, col);
    private static ArrayList<Player> players = new ArrayList<>();

    public static Referee getReferee(){
        return referee;
    }
    public static Board getBoard(){
        return board;
    }
    public static BoardService getBoardService(){
        return boardService;
    }
    public static ArrayList<Player> getPlayers(){
        return players;
    }
    public static PlayerService getPlayerService(){
        return playerService;
    }
    public static int getRow(){
        return row;
    }
    public static int getCol(){
        return col;
    }
}
