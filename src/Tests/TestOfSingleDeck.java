package Tests;
import com.ua.seawar.*;

public class TestOfSingleDeck {
    public static void main(String[] args) {
        Player player = new Player();
        player.showCount();
        player.setSingleDeck(1, 1);
        player.showCount();
        player.setSingleDeck(1, 2);
        player.showCount();
        player.setSingleDeck(1, 3);
        player.showCount();
        player.setSingleDeck(1, 4);
        player.showCount();
        player.setSingleDeck(1, 5);
    }
}
