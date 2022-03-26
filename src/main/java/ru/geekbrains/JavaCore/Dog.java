package ru.geekbrains.JavaCore;

public class Dog implements Participant {
    private int maxSwimDistance;
    private int maxJumpHeight;
    private int maxRunDistance;
    private boolean onDistance;
    private String name;

    public Dog (String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isOnDistance() {
        return false;
    }

    @Override
    public void run(int distance) {

    }

    @Override
    public void jump(int height) {

    }

    @Override
    public void swim(int distance) {

    }

    @Override
        public String toString() {
            return "Barbos" + name + " : " + (isOnDistance() ? "at a distance" : "went out of the way");
        }
}
