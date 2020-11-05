import java.util.Arrays;

public class ThreeDeck extends Ship {
    private String deckValue = "t";

    public String[] create() {
        String[] ship = new String[3];
        Arrays.fill(ship, deckValue);

        return ship;
    }
}
