package ru.geekbrains.lesson1;
import java.util.Random;
import java.util.Scanner;
/**
 * Java 1. Homework #3
 *
 * @author Olga Philippova
 * @version 19.02.2022
 */
public class Lesson4HomeWork {

    Random random;
    Scanner scanner;
    char[][] table;

    public static void main(String[] args) {
        new Lesson4HomeWork().game();
    }

    Lesson4HomeWork() {
            random = new Random();
            scanner = new Scanner(System.in);
            table = new char[3][3];
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
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++){
                table[x][y] = '.';
            }
        }
    }

    void printTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print("Enter x y [1..3]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = 'x';
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[x][y] = 'o';
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x> 2 || y > 2) {
            return false;
        }
        return table[x][y] == '.';
    }

    boolean checkWin(char ch) {
        //check vertical
        for (int y = 0; y < 3; y++) {
            boolean result = true;
            for (int x = 0; x < 3; x++) {
                if (table[x][y] != ch) {
                    result = false;
                    break;
                }
            }
            if (result)
                return true;
        }
        //check horizontal
        for (int y = 0; y < 3; y++) {
            boolean result = true;
            for (int x = 0; x < 3; x++) {
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
        for (int y = 0; y < 3; y++) {
            if (table[y][y] != ch) {
                result = false;
                break;
            }
        }
        if (result)
            return true;

        //check diagonal
        result = true;
        for (int y = 0; y < 3; y++) {
            if (table[y][2-y] != ch) {
                result = false;
                break;
            }
        }
        if (result)
            return true;

        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (table[x][y] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
