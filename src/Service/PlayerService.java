package Service;
import Domain.Player;
import tictactoe.Container;

import java.util.ArrayList;

public class PlayerService {
    public void addPlayer(char playerIdentifier){
        ArrayList<Player> players = Container.getPlayers();
        checkDuplicate(playerIdentifier, players);
        players.add(new Player(playerIdentifier));
    }
    private void checkDuplicate(char playerIdentifier, ArrayList<Player> players){
        for(Player player : players){
            if (playerIdentifier == player.getPlayerIdentifier()) {
                throw new IllegalStateException("이미 존재하는 Identifier입니다");
            }
        }
    }
    public char getPlayerIdentifierByIndex(int playerIndex) {
        return Container.getPlayers()
                .get(playerIndex).getPlayerIdentifier();
    }
}
