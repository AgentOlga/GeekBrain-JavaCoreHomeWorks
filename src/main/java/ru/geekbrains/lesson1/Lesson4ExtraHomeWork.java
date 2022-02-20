package ru.geekbrains.lesson1;
import java.util.Random;
import java.util.Scanner;
/**
 * Java 1. Homework #3
 *
 * @author Olga Philippova
 * @version 19.02.2022
 */
public class Lesson4ExtraHomeWork {

    Random random;
    Scanner scanner;
    char[][] table;

    public static void main(String[] args) {
        new Lesson4ExtraHomeWork().game();
    }

    Lesson4ExtraHomeWork() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[5][5];
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman ();
            if (checkWin('x')) {
                System.out.println("YOU WON");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW...");
                break;
            }
            turnAI();
            printTable();
            if (checkWin('o')) {
                System.out.println("AI WON");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW...");
                break;
            }
        }
        System.out.println("GAME OVER");
        printTable();
    }

    void initTable() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++){
                table[x][y] = '.';
            }
        }
    }

    void printTable() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print("Enter x y [1..5]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = 'x';
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(5);
            y = random.nextInt(5);
        } while (!isCellValid(x, y));
        table[x][y] = 'o';
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x> 4 || y > 4) {
            return false;
        }
        return table[x][y] == '.';
    }

    boolean checkWin(char ch) {
        //check vertical
        for (int y = 0; y < 5; y++) {
            boolean result = true;
            for (int x = 0; x < 5; x++) {
                if (table[x][y] != ch) {
                    result = false;
                    break;
                }
            }
            if (result)
                return true;
        }
        //check horizontal
        for (int y = 0; y < 5; y++) {
            boolean result = true;
            for (int x = 0; x < 5; x++) {
                if (table[y][x] != ch) {
                    result = false;
                    break;
                }
            }
            if (result)
                return true;
        }
        //check diagonal
        boolean result = true;
        for (int y = 0; y < 5; y++) {
            if (table[y][y] != ch) {
                result = false;
                break;
            }
        }
        if (result)
            return true;

        //check diagonal
        result = true;
        for (int y = 0; y < 5; y++) {
            if (table[y][4-y] != ch) {
                result = false;
                break;
            }
        }
        if (result)
            return true;

        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (table[x][y] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
