package ru.geekbrains.lesson1;
/**
 * Java 1. Homework #5
 *
 * @author Olga Philippova
 * @version 23.02.2022
 */
public class Lesson5HomeWork {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", 892312312, 230000, 30);
        persArray[1] = new Person("Petrov Peter","QA engineer" , "ghb@gmail.com" , 768474936 , 134900, 26);
        persArray[2] = new Person("Pupkina Ekaterina" , "Accountant" , "ekpup@gmail.com" , 672384610, 157000, 45);
        persArray[3] = new Person("Grigoriev Anatoly" , "Engineer" , "ggriig@gmail.com" , 450011229 , 235000, 37);
        persArray[4] = new Person("Fedunkov Maksim" , "Manager" , "fdmhoy@gmail.com" , 777444555 ,189000, 42);

        for (int i = 0; i < persArray.length; i++) {
            Person person = persArray[i];
            if (person.getAge() > 40)
                person.print();
        }
    }
}

class Person {
    private final String name;
    private final String position;
    private final String email;
    private final int phone;
    private final float salary;
    private final int age;

    public int getAge() {
        return age;
    }

    Person(String name, String position, String email, int phone, float salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.phone = phone;
        this.age = age;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString () {
        return name + "," + position + "," + email + "," + phone +"," + salary + "," + age;
    }
}
