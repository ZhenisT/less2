package lesson8a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;


    public char[][] field;
    public static int fieldSizeX;
    int fieldSizeY;
    public static int winLength;
    int cellHeight;
    int cellWidth;
    int cellX;
    int cellY;


    boolean isInit = false;
    boolean humanWent = true;
    boolean humanWent1 = false;
    boolean gameOver = false;
    String gameOverMessage = "";


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
        if (mode == 0) {
            start();
        }
        if (mode == 1) {
            humanWent = true;
            humanWent1 = false;
            start1();
        }
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
                if (logic.field[i][j] != logic.DOT_EMPTY) {
                    if (logic.field[i][j] == 'X') {
                        g.drawLine((j * cellHeight), (i * cellWidth), (j + 1) * cellHeight, (i + 1) * cellWidth);
                        g.drawLine((j + 1) * cellHeight, (i * cellWidth), (j * cellHeight), (i + 1) * cellWidth);
                    }
                    if (logic.field[i][j] == 'O') {
                        g.drawOval((j * cellHeight), (i * cellWidth), cellWidth, cellHeight);
                    }
                }
                if (gameOver) {

                    g.setColor(Color.RED);
                    g.setFont(new Font("Tahoma", 10, 40));
                    g.drawString(gameOverMessage,(getWidth()/2)-cellHeight,(getHeight()/2));
                }
            }
        }


    }


    public void start() {
        logic.initMap();
        logic.printMap();
        isInit = true;
        System.out.println("start...");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX() / cellWidth;
                int y = e.getY() / cellHeight;
                if (logic.isCellValid(x, y)) {
                    logic.field[y][x] = logic.DOT_X;
                    if (logic.checkWin(logic.DOT_X)) {
                        gameOverMessage = "Вы победитель!";
                        gameOver = true;
                        System.out.println("Вы победитель!");
                        return;
                    }
                    if (logic.isFull()) {
                        gameOverMessage = "Ничья";
                        gameOver = true;
                        System.out.println("Ничья");
                        return;
                    }

                    System.out.println(y + " " + x);
                    logic.printMap();
                    humanWent = true;
                    logic.aiTurn();
                    logic.printMap();
                    System.out.println("ai turned");

                    if (logic.checkWin(logic.DOT_O)) {
                        gameOverMessage = "Компьютер победил!";
                        gameOver = true;
                        System.out.println("Компьютер победил!");
                        return;
                    }

                    if (logic.isFull()) {
                        gameOverMessage = "Ничья";
                        gameOver = true;
                        System.out.println("Ничья");
                        return;
                    }
                }
            }
        });


    }

    public void start1() {
        logic.initMap();
        logic.printMap();
        isInit = true;
        System.out.println("start...");

        if (humanWent) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    int x = e.getX() / cellWidth;
                    int y = e.getY() / cellHeight;
                    if (logic.isCellValid(x, y)) {

                        if (humanWent) {
                            logic.field[y][x] = logic.DOT_O;
                            repaint();
                            humanWent = false;
                            humanWent1 = true;
                        }


                        logic.printMap();
                        System.out.println("Ходит игрок 1");

                        if (logic.checkWin(logic.DOT_O)) {
                            gameOverMessage = "Вы победитель! Игрок 1";
                            gameOver = true;
                            System.out.println("Вы победитель! Игрок 1");

                            return;

                        }
                        if (logic.isFull()) {
                            gameOverMessage = "Ничья";
                            gameOver = true;
                            System.out.println("Ничья");

                            return;
                        }


                    }
                }
            });
            humanWent1 = true;
        }


        if (humanWent1) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    int x = e.getX() / cellWidth;
                    int y = e.getY() / cellHeight;
                    if (logic.isCellValid(y, x)) {

                        logic.field[y][x] = logic.DOT_X;
repaint();
                        humanWent1 = false;
                        humanWent = true;

                        logic.printMap();
                        System.out.println("Ходит игрок 2");

                        if (logic.checkWin(logic.DOT_X)) {
                            gameOverMessage = "Вы победитель! Игрок 2";
                            gameOver = true;
                            System.out.println("Вы победитель! Игрок 2");

                            return;
                        }
                        if (logic.isFull()) {
                            gameOverMessage = "Ничья";
                            gameOver = true;
                            System.out.println("Ничья");

                            return;
                        }


                    }
                }

            });
            humanWent = true;
        }
    }
}

