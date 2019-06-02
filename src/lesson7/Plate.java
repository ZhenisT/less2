package lesson7;

import java.util.Scanner;

public class Plate {
    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
        System.out.println("В тарелке осталось: " + food);
    }

    public void info() {
        System.out.println("В тарелке еды: " + food);
    }

    public void addFood() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько еды хотите добавить? ");
        food += sc.nextInt();
    }

}