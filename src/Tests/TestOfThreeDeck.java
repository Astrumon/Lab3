package Tests;
import com.ua.seawar.*;
public class TestOfThreeDeck {
    public static void main(String[] args) {
        Player player = new Player();
        player.setThreeDecks(1, 1);
        player.setThreeDecks(1, 3);
        player.setThreeDecks(6, 5);
        player.setThreeDecks(6, 5);
    }
}
