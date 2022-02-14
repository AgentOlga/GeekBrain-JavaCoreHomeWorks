package ru.geekbrains.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Apple");
        System.out.println("Banana");
    }

    static void checkSumSign() {
        int tasksCount1 = 6;
        int tasksCount2 = 2;
        int sum = tasksCount1 + tasksCount2;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 1;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value >0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 10;
        int b = 4;
        if (a >= b) {
            System.out.println("a >= b");
        }
        if (a>b) {
            System.out.println("a>b");
        }
    }


}

