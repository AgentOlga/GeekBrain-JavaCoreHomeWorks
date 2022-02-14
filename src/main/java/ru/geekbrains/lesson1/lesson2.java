package ru.geekbrains.lesson1;

public class lesson2 {
    public static void main(String[] args) {
        System.out.println("method2_1 returns: " + method2_1(8, 3));
        method2_2(-10);
        System.out.println("method2_3 returns: " + method2_3(23));
        method2_4( "I have fun",9);
        System.out.println("leap_year returns: " + leap_year(2024));
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
        for ( int i = 0; i < times; i++) {
            System.out.println(word);
        }
    }

    static boolean leap_year(int year) {
        if ( year % 4 != 0)
            return false;

        if (year % 100 == 0 && year % 400 != 0)
            return false;

        return true;
    }
}
