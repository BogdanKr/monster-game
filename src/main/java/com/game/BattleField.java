package com.game;


import java.util.Random;

public class BattleField {
    private char[][] field;

    public BattleField(int x, int y) {
        field = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                field[i][j] = ' ';
            }
        }
        for (int i = 0; i < y; i++) {
            field[x - 1][i] = '_';
        }
    }

    public int getFieldWidth() {
        return field[0].length;
    }

    public int getFieldHeight() {
        return field.length;
    }

    public String viewBattleField() {
        String str = "[";
        for (int i = 0; i < getFieldHeight(); i++) {
            for (int j = 0; j < getFieldWidth(); j++) {
                if (j < getFieldWidth() - 1) str = str + field[i][j] + ".";
                else str = str + field[i][j];
            }
            if (i < getFieldHeight() - 1) str = str + "]\n[";
            else str = str + "]\n";
        }
        return str;
    }

    public void setNeedField(int x, int y, char c) {
        field[x][y] = c;
    }

    public char fieldChar(int x, int y) {
        return field[x][y];
    }

    public int moveRandomLeftRight(int x) {
        Random random = new Random();
        if (x > 0 && x < field[0].length - 1)
            x = x + random.nextInt(3) - 1;
        else if (x == 0) x = x + random.nextInt(2);
        else x = x - random.nextInt(2);
        return x;
    }

    public int moveRandomUpDown(int x) {
        Random random = new Random();
        if (x > 0 && x < field.length - 1)
            x = x + random.nextInt(3) - 1;
        else if (x == 0) x = x + random.nextInt(2);
        else x = x - random.nextInt(2);
        return x;
    }

    public int moveRight(int x, int y, char symbol) {
        if (y < field[0].length - 1) {
            if (x == field.length - 1) {
                field[x][y] = '_';
                y++;
                field[x][y] = symbol;
            } else {
                field[x][y] = ' ';
                y++;
                field[x][y] = symbol;
            }
        }
        return y;
    }

    public int moveLeft(int x, int y, char symbol) {
        if (y > 0) {
            if (x == field.length - 1) {
                field[x][y] = '_';
                y--;
                field[x][y] = symbol;
            } else {
                field[x][y] = ' ';
                y--;
                field[x][y] = symbol;
            }
        }
        return y;
    }

    public int moveDown(int x, int y, char symbol) {
        if (x < field.length - 1) {
            field[x][y] = ' ';
            x++;
            field[x][y] = symbol;
        }
        return x;
    }

    public int moveUp(int x, int y, char symbol) {
        if (x > 0) {
            if (x == field.length - 1) {
                field[x][y] = '_';
                x--;
                field[x][y] = symbol;
            } else {
                field[x][y] = ' ';
                x--;
                field[x][y] = symbol;
            }
        }
        return x;
    }
}
