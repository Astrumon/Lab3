package Tests;

import com.ua.seawar.Player;

public class TestEmptySpace {
    public static void main(String[] args) {
        Player player = new Player();
        player.setSingleDeck(1, 'A');
        player.setSingleDeck(2, 'A');
        player.setSingleDeck(3, 'A');
        player.setSingleDeck(4, 'A');

        player.setDoubleDeck(1, 'C', 'v');
    }
}
