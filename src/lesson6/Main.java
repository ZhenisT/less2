package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурка", "белый", 2, 1);
        Cat cat1 = new Cat("Пушок", "серый", 3, 2);
        Dog dog = new Dog("Шарик", "черно-белый", 3, 2);
        Dog dog1 = new Dog("Тузик", "рыжий", 5, 1);

        dog.info();
        dog.jump(0.5);
        dog1.jump(1.5);
        dog.run(500);
        dog1.swim(135);
        cat.jump(2);
        cat1.run(251);
        cat.swim(100);
    }
}
