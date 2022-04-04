package ru.geekbrains.JavaCore;

import java.util.Arrays;
import java.util.List;

public class Lesson3 {
    public static void main(String[] args) {
        //Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
        String[] arr = {"asd", "ds", "ret", "123"};
        //Integer[] arr = {3, 4, 6, 234, -1324, 111};

        System.out.println("Task1\n" + Arrays.toString(arr));
        swapElements(arr, 2, 3);
        System.out.println(Arrays.toString(arr));

        //Написать метод, который преобразует массив в ArrayList
        List<String> list = convertToList(arr);
        System.out.println("Task2\n" + list.getClass() + " : " + list);


        System.out.println("Task 3");

        Box<Orange> orangeBox1 = new Box();
        for (int i = 0; i < 3; i++) {
            orangeBox1.add(new Orange());
        }

        Box<Orange> orangeBox2 = new Box();
        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }

        Box<Apple> appleBox = new Box();
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }


        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        System.out.println("Weight of box 1 with oranges: " + orangeBox1.getWeight());
        System.out.println("Weight of box 2 with oranges: " + orangeBox2.getWeight());
        System.out.println("Apple box weight:" + appleBox.getWeight());

        System.out.println("Compare weight of orangeBox1 and appleBox: " + orangeBox1.compare(appleBox));
        System.out.println("Compare weight of orangeBox2 and appleBox: " + orangeBox2.compare(appleBox));

        orangeBox1.moveAt(orangeBox2);
//            orangeBox1.moveAt(appleBox);   Error

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}
