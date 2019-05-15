package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    public static final int SIZE = 5;
    public static final int SIZETOWIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initmap();
        printmap();
        while (true) {
            humanTurn();
            printmap();
            if (checkWin(DOT_X)) {
                System.out.println("Поздравляю! Вы победили!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            aiTurn();
            printmap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект :)");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }
        System.out.println("Игра закончена. Пока!");
        sc.close(); 
    }


    public static void initmap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printmap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Не верный ход");
            return false;
        }
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход! Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        iiBlock(DOT_X);
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сделал ход " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - SIZETOWIN + 1); j++) {
                //Проверка по строкам слева на право
                if ((map[i][j] == symb) && (map[i][j] == map[i][j + 1]) && (map[i][j] == map[i][j + 2]) && (map[i][j] == map[i][j + 3])) {
                    return true;
                }
                //Проверка столбцов сверху вниз
                if ((map[j][i] == symb) && (map[j][i] == map[j + 1][i]) && (map[j][i] == map[j + 2][i]) && (map[j][i] == map[j + 3][i])) {
                    return true;
                }
            }
        }
        //Проверка главной диагонали
        for (int i = 0; i < (SIZE - SIZETOWIN + 1); i++) {
            for (int j = 0; j < (SIZE - SIZETOWIN + 1); j++) {
                if ((map[i][j] == symb) && (map[i][j] == map[i + 1][j + 1]) && (map[i][j] == map[i + 2][j + 2]) && (map[i][j] == map[i + 3][j + 3])) {
                    return true;
                }
            }
        }
        //Проверка побочной диагонали
        for (int i = SIZE - 2; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - SIZETOWIN + 1); j++) {
                if ((map[i][j] == symb) && (map[i][j] == map[i - 1][j + 1]) && (map[i][j] == map[i - 2][j + 2]) && (map[i][j] == map[i - 3][j + 3])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void iiBlock(char symb){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                //Проверка по строкам слева на право
                if ((map[i][j] == symb) && (map[i][j] == map[i][j + 1])) {
                   if (map[i][j+2] == DOT_EMPTY){
                    map[i][j+2]=DOT_O;}
                }
                //Проверка столбцов сверху вниз
                if ((map[i][j] == symb) && (map[i][j] == map[j + 1][i])) {
                        if (map[j + 2][i] == DOT_EMPTY){
                            map[j + 2][i]=DOT_O;}
                    }
                }
            }
       //Проверка главной диагонали
        for (int i = 0; i < (SIZE - 2); i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                if ((map[i][j] == symb) && (map[i][j] == map[i + 1][j + 1])) {
                    if (map[i + 2][j+2] == DOT_EMPTY){
                        map[i + 2][j+2]=DOT_O;}
                }
            }
        }
        //Проверка побочной диагонали
        for (int i = SIZE - 3; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                if ((map[i][j] == symb) && (map[i][j] == map[i - 1][j + 1])) {
                    if (map[i -2][j+2] == DOT_EMPTY){
                        map[i -2][j+2]=DOT_O;}
                }
            }
        }
    }

}
