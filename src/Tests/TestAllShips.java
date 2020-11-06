package Tests;
import com.ua.seawar.*;

public class TestAllShips {
    public static void main(String[] args) {
        Player player = new Player();

        player.setSingleDeck(1, 'A');
        player.setSingleDeck(3, 'E');
        player.setSingleDeck(5, 'F');
        player.setSingleDeck(1, 'I');

        player.setDoubleDeck(1, 'C', 'v');
        player.setDoubleDeck(6, 'H', 'g');
        player.setDoubleDeck(7, 'A', 'g');

        player.setThreeDeck(7, 'F', 'v');
        player.setThreeDeck(1, 'F', 'v');

        player.setFourDeck(10, 'G', 'g');
        //player.setSingleDeck(7, 'J');
    }
}
