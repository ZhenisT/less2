package lesson7;

public class Cat {
    private String name;
    public int appetite;
    private boolean notHungry = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (notHungry) {
            System.out.println(name + " Не голоден!");
        }
        if (!notHungry && p.food >= appetite) {
            p.decreaseFood(appetite);
            appetite -= appetite;
            notHungry = true;
        }
        System.out.println(name + " покушал? " + notHungry);
        if (!notHungry && p.food < appetite) {
            System.out.println("Еды не хватило!  В тарелке осталось - " + p.food + "  " + name + " хочет " + appetite);
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", notHungry=" + notHungry +
                '}';
    }
}
