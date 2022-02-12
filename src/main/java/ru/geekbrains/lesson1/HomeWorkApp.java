package ru.geekbrains.lesson1;

public class HomeWorkApp
{
    public static void main(String[] args)
    {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println("method2_1 returns: " + method2_1(8, 3));
        method2_2(-10);
        System.out.println("method2_3 returns: " + method2_3(23));
        method2_4( "I have fun",9);

    }
    static void printThreeWords()
    {
        System.out.println("Orange");
        System.out.println("Apple");
        System.out.println("Banana");
    }

    static void checkSumSign()
    {
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
    static void printColor()
    {
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
    static void compareNumbers()
    {
        int a = 10;
        int b = 4;
        if (a >= b) {
            System.out.println("a >= b");
        }
        if (a>b) {
            System.out.println("a>b");
        }
    }

    static boolean method2_1(int param1, int param2) {
        int sum = param1 + param2;
        return sum >= 10 && sum <= 20;
    }

    static void method2_2(int param) {
        System.out.println(param >= 0 ? "Positive" : "Negative");
    }

    static boolean method2_3(int param) {
        return param < 0;
        }



    public static void method2_4(String word, int times) {
        for ( int i = 0; i < times; i++){
            System.out.println(word);
        }
    }
}

