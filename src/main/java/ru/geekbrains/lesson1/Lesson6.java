package ru.geekbrains.lesson1;
/**
 * Java 1. Homework #6
 *
 * @author Olga Philippova
 * @version 26.02.2022
 */
public class Lesson6 {
    public static void main(String[] args){
        Dog bobik = new Dog(500, 10);
        bobik.run(200);
        bobik.swim(200);

        Cat murzik = new Cat(200, 0);
        murzik.run(150);
        murzik.swim(200);
    }
}

abstract class Animal {
    protected int maxRunLength;
    protected int maxSwimLenght;

    protected Animal(int maxLength, int maxSwimLenght) {
        this.maxRunLength = maxLength;
        this.maxSwimLenght = maxSwimLenght;
    }

    abstract void run(int length);
    abstract void swim(int length);
}

class Cat extends Animal {
    private final int MAX_RUN_LENGTH = 200;

    protected Cat(int maxLength, int maxSwimLenght) {
        super(maxLength, maxSwimLenght);
    }

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= maxRunLength))
            System.out.println("run: true");
        else
            System.out.println("run: false");
    }

    @Override
    void swim(int length) {
        System.out.println("swim: false");
    }
}

class Dog extends Animal {

    protected Dog(int maxLength, int maxSwimLenght) {
        super(maxLength, maxSwimLenght);
    }

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= maxRunLength)) System.out.println("run: true");
    }

    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= maxSwimLenght)) System.out.println("swim: true");
        else System.out.println("swim: false");
    }
}


