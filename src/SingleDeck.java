public class SingleDeck extends Ship {
    private String deckValue = "s";

    public String[] create() {
        String[] ship = new String[1];
        ship[0] = deckValue;

        return ship;
    }
}
