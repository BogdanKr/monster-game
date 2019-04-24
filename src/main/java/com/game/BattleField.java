package com.game;


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


}
