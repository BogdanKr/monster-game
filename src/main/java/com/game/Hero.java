package com.game;

public class Hero {
    private BattleField field;
    private int playerX;
    private int playerY;
    private char view = 'X';

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public Hero(BattleField field) {
        this.field = field;
        playerY = field.getFieldWidth() / 2;
        playerX = field.moveUp(field.getFieldHeight(),playerY,view);
    }

    public void moveLeft() {
        playerY = field.moveLeft(playerX, playerY, view);
    }

    public void moveRight() {
        playerY = field.moveRight(playerX, playerY, view);
    }

    public void moveDown() {
        playerX = field.moveDown(playerX, playerY, view);
    }

    public void moveUp() {
        playerX = field.moveUp(playerX, playerY, view);
    }
}
