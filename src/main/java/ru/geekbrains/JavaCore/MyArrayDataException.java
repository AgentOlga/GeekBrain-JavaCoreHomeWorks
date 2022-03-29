package ru.geekbrains.JavaCore;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("Wrong data in cell " + i + ", " + j);
    }
}
