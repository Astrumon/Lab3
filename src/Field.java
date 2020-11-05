public class Field {

    private static final int SIZE_ARRAY = 12;
    private String[][] arrayField = new String[SIZE_ARRAY][SIZE_ARRAY];
    private static final String VALUE_HIDE = "#";

    public Field() {
        String defaultValue = "*";
        initializeField(defaultValue);
    }

    public void showField() {
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                System.out.print(arrayField[i][j] + "\t");
            }
            System.out.println();
        }
    }



    public void hideBattleField() {
        initializeField(VALUE_HIDE);
    }

    public void initializeField(String value) {
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                if (i != SIZE_ARRAY - 1 && j != SIZE_ARRAY - 1) {
                    arrayField[i][0] = String.valueOf(i);
                    arrayField[0][j] = String.valueOf((char) (j + 64));
                }
                if (i == SIZE_ARRAY - 1) {
                    arrayField[i][j] = "_";
                } else if (j == SIZE_ARRAY - 1) {
                    arrayField[i][j] = "|";
                } else {
                    arrayField[i][j] = value;
                }
            }
        }
    }

}
