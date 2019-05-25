package lesson5;

public class Person {
    String FIO;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Person(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
     Person() {
        FIO = "Name Surname";
        position = "meneger";
        email = "@mail.ru";
        phone = "8 495 495 15 35";
        salary = 70000;
        age = 30;
    }

    public void info(){
        System.out.println("ФИО: " + FIO + ";" + " Должность: " + position + ";" + " email: " + email + ";" + " телефон: " + phone + ";" + " З/П - " + salary + ";" + " Возраст: " + age + ".");
    }


}
