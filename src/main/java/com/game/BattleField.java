package com.game;

import jline.console.ConsoleReader;

import java.util.Arrays;
import java.io.IOException;


public class BattleField {
    private char[][] field;
    private final ConsoleReader consol;

    public BattleField(int x, int y, ConsoleReader consol) {
        field = new char[x][y];
        this.consol = consol;
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

    public void viewBattleField() throws IOException {
        consol.clearScreen();
        consol.println("GoGoGoooo");
        for (int i = 0; i < getFieldHeight(); i++) {
            consol.println(Arrays.toString(field[i]));
            consol.flush();
        }
    }

    public void setNeedField(int x, int y, char c) {
        field[x][y] = c;
    }

    public char fieldChar(int x, int y){
        return field[x][y];
    }


}
