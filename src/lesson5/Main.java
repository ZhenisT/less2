package lesson5;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.info();
        System.out.println();

        Person[] personList = new Person[5];
        personList[0] = new Person("Иванов Сергей", "охраник", "ivansec@mail.ru", "84121123123", 30000, 56);
        personList[1] = new Person("Светлова Олеся", "офис менеджер", "svetOle@mail.ru", "84121546511", 38000, 40);
        personList[2] = new Person("Архимедова Светлана", "бухгалтер", "archSveta@mail.ru", "84121845546", 42000, 25);
        personList[3] = new Person("Новиков Андрей", "программист", "novikov.a@mail.ru", "84121856311", 75000, 34);
        personList[4] = new Person("Старков Николай", "директор", "stanik@mail.ru", "84121897452", 115000, 42);

        System.out.println("Список сотрудников из массива");
        for (Person printArr : personList
        ) {
            printArr.info();
        }
        System.out.println();
        System.out.println("Список сотрудников от 40 лет");
        for (int i = 0; i < personList.length; i++) {
            if (personList[i].age >= 40) {
                personList[i].info();
            }
        }


    }
}
