import java.util.Arrays;

public class DoubleDeck extends Ship {
    private String deckValue = "d";

    public String[] create() {
        String[] ship = new String[2];
        Arrays.fill(ship, deckValue);

        return ship;
    }
}
