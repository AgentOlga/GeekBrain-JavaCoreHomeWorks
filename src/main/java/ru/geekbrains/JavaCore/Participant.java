package ru.geekbrains.JavaCore;

public interface Participant {

    String getName();

    boolean isOnDistance();

    void run(int distance);
    void jump(int height);
    void swim(int distance);
}
