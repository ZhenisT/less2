package lesson6.Animal;


public class Cat extends Animal {

    public Cat() {
        super();
    }

    public Cat(String name, String color, int age, int power) {
        super(name, color, age, power);
    }


    @Override
    public void jump(double x) {
        int heightJump;
        if (power == 1) {
            heightJump = 2;
            System.out.println(name + " перепрыгнул(а) препятствие в - " + (int) x + " метров. " + "Результат: " + resultPower(x, heightJump));
        } else {
            heightJump = 3;
            System.out.println(name + " перепрыгнул(а) препятствие в - " + (int) x + " метров. " + "Результат: " + resultPower(x, heightJump));
        }

    }

    @Override
    public void run(int x) {
        int lengthRun;
        if (power == 1) {
            lengthRun = 200;
            System.out.println(name + " пробежал(а) расстояние в - " + x + " метров. " + "Результат: " + resultPower(x, lengthRun));
        } else {
            lengthRun = 250;
            System.out.println(name + " пробежал(а) расстояние в - " + x + " метров. " + "Результат: " + resultPower(x, lengthRun));
        }

    }

    @Override
    public void swim(int x) {
        System.out.println(name + " не умеет плавать");
    }

}
