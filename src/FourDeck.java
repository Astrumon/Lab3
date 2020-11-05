import java.util.Arrays;

public class FourDeck extends Ship {
    private String deckValue = "f";

    public String[] create() {
        String[] ship = new String[4];
        Arrays.fill(ship, deckValue);

        return ship;
    }
}
