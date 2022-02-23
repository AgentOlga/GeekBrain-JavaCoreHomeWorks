package ru.geekbrains.lesson1;

public class Lesson5 {
    public static void main(String[] args) {
        Cat cat = new Cat("Murzik", "black", 3);
        System.out.println(cat.voice());
        System.out.println(cat);
    }
}

class Cat {
    private String name;
    private String color;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

        String voice() {
        return "meow";
    }

    Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString () {
        return name + "," + color + "," + age;
    }
}
