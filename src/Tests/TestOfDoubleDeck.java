package Tests;
import com.ua.seawar.*;

public class TestOfDoubleDeck {
    public static void main(String[] args) {
        Player player = new Player();
        player.setDoubleDeck(10, 'A', 'g');
        player.setDoubleDeck(1, 'A', 'v');
        player.setFourDeck(7, 'D', 'g');
    }
}
