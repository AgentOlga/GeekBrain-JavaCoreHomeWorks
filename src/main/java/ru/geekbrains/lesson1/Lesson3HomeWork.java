package ru.geekbrains.lesson1;
import java.util.Arrays;
/**
 * Java 1. Homework #3
 *
 * @author Olga Philippova
 * @version 16.02.2022
 */
public class Lesson3HomeWork {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();

        System.out.println(Arrays.toString(initArray(6, 3)));
        minMaxArray();
    }

    public static void invertArray() {
        int[] arr = { 1, 0, 1, 0, 0, 1 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        arr[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j)
                arr[i][j] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] initArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }

        return arr;
    }

    public static void minMaxArray() {
        int[] arr = {-3, 5, 7, 90, 32,-6, 12, 76, 4};
        int max = -100, min = 100;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
