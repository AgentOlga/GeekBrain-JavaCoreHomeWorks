package ru.geekbrains.lesson1;
/**
 * Java 1. Homework #7
 *
 * @author Olga Philippova
 * @version 01.03.2022
 */
public class Lesson7HomeWork {
    public static void main(String[] args) {

        int action;
        Cat[] allCats = new Cat[4];
        allCats[0] = new Cat("Barsik", 5, false);
        allCats[1] = new Cat("Snow", 30, false);
        allCats[2] = new Cat("Murzik", 10, false);
        allCats[3] = new Cat("Blacky", 45, false);

        Plate plate = new Plate(15);
        plate.info();
        for (int i = 0; i < allCats.length; i++) {
            if (allCats[i].fullness == false && allCats[i].appetite < plate.food) {
                allCats[i].eat (plate);
                allCats[i].fullness = true;
                System.out.println("Cat " + allCats[i].name + " ate!");
            } else
            {
                System.out.println("Cat " + allCats[i].name + " didn't eat!");
            }
        }
        plate.info();
        System.out.println("How many grams of food did you add to the bowl?");
        plate.increaseFood(10);
        plate.info();
    }
}

class Cat {
    public String name;
    public int appetite;
    public boolean fullness;

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public void eat(Plate p ){
        p.decreaseFood(appetite);

    }
}

class Plate {
    public int food;

    public Plate (int food) {
        this.food = food;
    }

    public void increaseFood(int food) {
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void decreaseFood(int appetite) {
    }
}




