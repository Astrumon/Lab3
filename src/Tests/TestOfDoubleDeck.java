package Tests;
import com.ua.seawar.*;

public class TestOfDoubleDeck {
    public static void main(String[] args) {
        Player player = new Player();
        player.setDoubleDeck(1, 1);
        player.setDoubleDeck(4, 1);
        player.setDoubleDeck(1, 4);
        player.setDoubleDeck(1, 8);

    }
}
