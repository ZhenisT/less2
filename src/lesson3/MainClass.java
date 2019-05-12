package lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            Random rand = new Random();
            int x = rand.nextInt(10);
            unNumb(x);


        } while (startGame() == true);
    }

    public static void unNumb(int x) {

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите ваше число");
            int d = sc.nextInt();

            if (x == d) {
                System.out.println("Вы угадали!!!");
                break;
            }
            if (x > d) System.out.println("Искомое число больше");
            if (x < d) System.out.println("Искомое число меньше");
            System.out.println("Не угадали");
        }

    }

    public static boolean startGame() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int v = sc.nextInt();
        if (v == 1) return true;
        return false;

    }

}