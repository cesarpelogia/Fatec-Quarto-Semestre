package edu.fatec.ui.common;

import edu.fatec.ShadowsOfBertoland2.core.characters.players.Player;

public class GameState {

    private static Player selectedPlayer;

    public static void setSelectedPlayer(Player player) {
        GameState.selectedPlayer = player;
    }

    public static Player getSelectedPlayer() {
        return GameState.selectedPlayer;
    }
}
