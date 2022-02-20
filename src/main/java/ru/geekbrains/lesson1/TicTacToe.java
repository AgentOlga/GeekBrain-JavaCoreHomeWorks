package ru.geekbrains.lesson1;
import java.util.Random;
import java.util.Scanner;
/**
 * Java 1. Homework #4
 *
 * @author Olga Philippova
 * @version 20.02.2022
 */
public class TicTacToe {

    Random random;
    Scanner scanner;
    char[][] table;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table[i][j] = '.';
            }
        }
    }

    void printTable() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(table[i][j] + " ");
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
        if (x < 0 || y < 0 || x >= 5 || y >= 5)  return false;
        if (table[y][x] == '.') return true;
        return false;
    }

    boolean checkWin(char ch) {
        int diag1,diag2, hor, ver;
        for (int i = 0; i < 5; i++) {
            hor = 0; ver = 0;
            for (int j = 0; j < 5; j++) {
                if (table[i][j] == ch) {
                    hor++;
                }
                if (table[j][i] == ch) {
                    ver++;
                }
            }
            if (hor == 5 || ver == 5) {
                return true;
            }
        }
        diag1 = 0; diag2 = 0;
        for (int i = 0; i < 5; i++) {
            if (table[i][i] == ch) {
                diag1++;
            }
            if (table[i][5 - i - 1] == ch) {
                diag2++;
            }
        }
        if (diag1 == 5 || diag2 == 5) {
            return true;
        }
        return false;
    }

    boolean isTableFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (table[i][i] == '.') return false;
            }
        }
        return true;
    }
}
