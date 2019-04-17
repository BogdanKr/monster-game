package com.game;

import jline.console.ConsoleReader;

import java.util.Arrays;
import java.io.IOException;


public class BattleField {
    private char[][] field;
    private final ConsoleReader consol;
    private int playerX;
    private int playerY;
    private Monster[] monster;

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
        playerX = x - 1;
        playerY = y / 2 - 1;
        field[playerX][playerY] = 'X';
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

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void setNeedField(int x, int y, char c) {
        field[x][y] = c;
    }
    public char fieldChar(int x, int y){
        return field[x][y];
    }

    public boolean checkAlive(Monster[] monster) {
        this.monster = monster;
        for (int i = 0; i < monster.length; i++) {
            if (monster[i].getMonsterX() == playerX && monster[i].getMonsterY() == playerY) {
                setNeedField(playerX,playerY,'D');
                return false;
            }
        }
        return true;
    }
}
