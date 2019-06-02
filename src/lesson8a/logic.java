package lesson8a;

import java.util.Random;

public class logic extends Map {

//    public static final int fieldSize = 5;
//    public static final int SIZETOWIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] field;



    static boolean humanWent = false;
    static Random random = new Random();

    public static void initMap() {
        field = new char[fieldSizeX][fieldSizeX];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }


    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= fieldSizeX; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void aiTurn() {

        int x = -1, y = -1;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        x = j;
                        y = i;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }

        if (x == -1 && y == -1) {
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeX);
            } while (!isCellValid(y, x));
        }

    field[y][x] = DOT_O;
    humanWent = false;

    }



    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= fieldSizeX || y >= fieldSizeX) {
            return false;
        }
        return field[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        int k = 0;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    k++;
                }
            }
        }
        return k == 0;
    }

    public static boolean checkWin(char symbol) {

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (checkGorizont(i, j, symbol) || checkVertical(i, j, symbol)
                        || checkDiogonal1(i, j, symbol) || checkDiogonal2(i, j, symbol)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static  boolean checkGorizont(int x, int y, char symbol) {
        if (x < 0 || y < 0 || x + winLength > fieldSizeX) {
            return false;
        }
        int k = 0;
        for (int i = 0; i < winLength; i++) {
            if (field[i + x][y] == symbol) {
                k++;
            }
        }
        return k == winLength;
    }

    public static boolean checkVertical(int x, int y, char symbol) {
        if (x < 0 || y < 0 || y + winLength > fieldSizeX) {
            return false;
        }
        int k = 0;
        for (int i = 0; i < winLength; i++) {
            if (field[x][y + i] == symbol) {
                k++;
            }
        }
        return k == winLength;
    }

    public static boolean checkDiogonal1(int x, int y, char symbol) {
        if (x < 0 || y < 0 || x + winLength > fieldSizeX || y + winLength > fieldSizeX) {
            return false;
        }
        int k = 0;
        for (int i = 0; i < winLength; i++) {
            if (field[x + i][y + i] == symbol) {
                k++;
            }
        }
        return k == winLength;
    }

    public static boolean checkDiogonal2(int x, int y, char symbol) {
        if (x < 0 || x + winLength > fieldSizeX || y + 1 - winLength < 0) {
            return false;
        }
        int k = 0;
        for (int i = 0; i < winLength; i++) {
            if (field[x + i][y - i] == symbol) {
                k++;
            }
        }
        return k == winLength;
    }


}
