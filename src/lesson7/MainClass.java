package lesson7;


public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурзик", 15);
        Cat cat1 = new Cat("Барсик", 25);
        Cat cat2 = new Cat("Снежок", 30);
        Cat[] cats = new Cat[5];
        cats[0] = cat;
        cats[1] = cat1;
        cats[2] = cat2;
        cats[3] = new Cat("Пушок", 15);
        cats[4] = new Cat("Хвостик", 35);
        Plate plate = new Plate(80);
        plate.info();
        for (Cat kot : cats) {
            while (kot.appetite > 0) {
                kot.eat(plate);
                if (kot.appetite > 0)
                    plate.addFood();
            }
        }

        plate.info();
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
            



    }

}
