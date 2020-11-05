import java.util.ArrayList;
import java.util.List;

public class Player {
    private Field field;

    private List<Ship> singleDecks, doubleDecks, threeDecks, fourDecks;
    private static int countSingleDeck = 4, countDoubleDeck = 3, countThreeDeck = 2, countFourleDeck = 1;

    public Player() {
        field = new Field();
        singleDecks = new ArrayList<Ship>();
        doubleDecks = new ArrayList<Ship>();
        threeDecks = new ArrayList<Ship>();
        fourDecks = new ArrayList<Ship>();
        for (int i = 0; i < countSingleDeck; i++) {
            singleDecks.add(new SingleDeck());
        }

        for (int i = 0; i < countDoubleDeck; i++) {
            doubleDecks.add(new DoubleDeck());
        }

        for (int i = 0; i < countThreeDeck; i++) {
            threeDecks.add(new ThreeDeck());
        }

        for (int i = 0; i < countFourleDeck; i++) {
            fourDecks.add(new FourDeck());
        }



    }

    public void setSingleDeck(int x, int y) {
        String[][] arrayField = field.getArrayField();

        for (int i = 0; i < arrayField.length; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                arrayField[x][y] = singleDecks.get(countSingleDeck-1).create()[0];
            }
        }
        countSingleDeck--;
        field.setArrayField(arrayField);
        field.showField();
    }



    public void showCount() {
        System.out.println(countSingleDeck);
    }


}
