package lesson6;

public class Dog extends Animal {
    int power;

    public Dog() {
        super();
    }

    public Dog(String name, String color, int age, int power) {
        super(name, color, age, power);
    }
    @Override
    public void jump(double x) {
        double heightJump;
        if (power == 1) {
            heightJump = 0.5;
            System.out.println(name + " перепрыгнул(а) препятствие в - " + x + " метров. " + "Результат: " + resultPower(x, heightJump));
        } else {
            heightJump = 1.2;
            System.out.println(name + " перепрыгнул(а) препятствие в - " + x + " метров. " + "Результат: " + resultPower(x, heightJump));
        }

    }

    @Override
    public void run(int x) {
        int lengthRun;
        if (power == 1) {
            lengthRun = 500;
            System.out.println(name + " пробежал(а) расстояние в - " + x + " метров. " + "Результат: " + resultPower(x, lengthRun));
        } else {
            lengthRun = 600;
            System.out.println(name + " пробежал(а) расстояние в - " + x + " метров. " + "Результат: " + resultPower(x, lengthRun));
        }

    }

    @Override
    public void swim(int x) {
        int swimDist;
        if (power == 1) {
            swimDist = 10;
            System.out.println(name + " проплыл дистанцию в - " + x + " метров. " + "Результат: " + resultPower(x, swimDist));
        } else {
            swimDist = 13;
            System.out.println(name + " проплыл дистанцию в - " + x + " метров. " + "Результат: " + resultPower(x, swimDist));
        }
    }


}
