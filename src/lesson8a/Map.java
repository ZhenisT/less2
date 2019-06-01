package lesson8a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;


    char[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;
    int cellHeight;
    int cellWidth;
    int cellX;
    int cellY;
    final char DOT_X = 'X';
    final char DOT_O = 'O';
    final char DOT_EMPTY = '*';

    static Random random = new Random();
    boolean isInit = false;
    boolean humanWent = false;
    boolean gameOver = false;



    public Map() {
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);

            }
        });
    }


    public void update(MouseEvent e) {
        cellX = e.getX() / cellWidth;
        cellY = e.getY() / cellHeight;
        System.out.println(cellX + " " + cellY);

        repaint();
    }


    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new char[fieldSizeY][fieldSizeX];
gameOver = false;

        isInit = true;
start();

        repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);

        repaint();
    }


    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);

        }

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] != DOT_EMPTY) {
                    if (field[i][j] == 'X') {
                        g.drawLine((j * cellHeight), (i * cellWidth), (j + 1) * cellHeight, (i + 1) * cellWidth);
                        g.drawLine((j + 1) * cellHeight, (i * cellWidth), (j * cellHeight), (i + 1) * cellWidth);
                    }
                    if (field[i][j] == 'O') {
                        g.drawOval((j * cellHeight), (i * cellWidth), cellWidth, cellHeight);
                    }
                }
            }
        }


    }


    public void start() {
        initMap();
        printMap();
        isInit = true;
        System.out.println("start...");
        while (gameOver == false) {

            humanTurn();
            System.out.println("human turned");

            if (checkWin(DOT_X)) {
                System.out.println("Вы победитель!");
gameOver = true;
                return;
            }

            if (isFull()) {
                System.out.println("Ничья");
                gameOver = true;
                return;
            }

            aiTurn();
            System.out.println("ai turned");

            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                gameOver = true;
                return;
            }

            if (isFull()) {
                System.out.println("Ничья");
                gameOver = true;
                return;
            }


        }

    }


    public void initMap() {
        field = new char[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }


    public void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= fieldSizeX; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < fieldSizeY; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void humanTurn() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX() / cellWidth;
                int y = e.getY() / cellHeight;
                if (isCellValid(x, y)) {
                    field[y][x] = DOT_X;
                    System.out.println(y + " " + x);
                    printMap();
                    humanWent = true;
                }
            }
        });



    }

    public void aiTurn() {

        int x = -1, y = -1;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
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
                y = random.nextInt(fieldSizeY);
            } while (!isCellValid(y, x));
        }

        field[y][x] = DOT_O;
        humanWent = false;
        printMap();

    }



    public boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= fieldSizeX || y >= fieldSizeY) {
            return false;
        }
        return field[y][x] == DOT_EMPTY;
    }

    public boolean isFull() {
        int k = 0;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    k++;
                }
            }
        }
        return k == 0;
    }

    public boolean checkWin(char symbol) {

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkGorizont(i, j, symbol) || checkVertical(i, j, symbol)
                        || checkDiogonal1(i, j, symbol) || checkDiogonal2(i, j, symbol)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkGorizont(int x, int y, char symbol) {
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

    public boolean checkVertical(int x, int y, char symbol) {
        if (x < 0 || y < 0 || y + winLength > fieldSizeY) {
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

    public boolean checkDiogonal1(int x, int y, char symbol) {
        if (x < 0 || y < 0 || x + winLength > fieldSizeX || y + winLength > fieldSizeY) {
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

    public boolean checkDiogonal2(int x, int y, char symbol) {
        if (x < 0 || x + winLength > fieldSizeY || y + 1 - winLength < 0) {
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

