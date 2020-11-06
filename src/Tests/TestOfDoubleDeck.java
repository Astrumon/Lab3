package Tests;
import com.ua.seawar.*;

public class TestOfDoubleDeck {
    public static void main(String[] args) {
        Player player = new Player();
        player.setDoubleDeck(1, 'A', 'g');
        player.setThreeDeck(1, 'A', 'g');
        player.setFourDeck(7, 'D', 'g');
    }
}
