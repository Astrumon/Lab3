public class Field {

    private static final int SIZE_ARRAY = 12;
    private String[][] arrayField = new String[SIZE_ARRAY][SIZE_ARRAY];

    public Field() {
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
               if (i == SIZE_ARRAY-1) {
                   arrayField[i][j] = "_";
               } else if(j == SIZE_ARRAY-1){
                   arrayField[i][j] = "|";
               } else {
                   arrayField[i][j] = "*";
               }
            }
        }
    }

    public void showField() {
        char ch;
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                if (j == 0 && i != SIZE_ARRAY-1) {
                    System.out.print(i + "\t");
                } else {
                    if ((i == 0) && (j != SIZE_ARRAY-1)) {
                        ch = (char)(j+64);
                        System.out.print(ch + "\t");
                    } else {
                        System.out.print(arrayField[i][j] + "\t");
                    }
                }
            }
            System.out.println();
        }
    }
}
