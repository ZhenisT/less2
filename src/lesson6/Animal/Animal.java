package lesson6.Animal;

public class Animal {
    String name;
    String color;
    int age;
    int power;

    public Animal() {

    }

     Animal(String name, String color, int age, int power) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.power = power;
    }
    public boolean resultPower(double x, double p) {
        if (x > p) return false;
        return true;
    }


    public void jump(double j){
        System.out.println(name+" может прыгнуть - " + j + " метров");
    }
    public void run(int r){
        System.out.println(name+" может пробежать - " + r + " метров");
    }
    public void swim(int s){
        System.out.println(name+" может проплыть - " + s + " метров)");
    }
    public void info(){
        System.out.println("кличка: " + name + " масть: " + color + " возраст: " + age);
    }
}
