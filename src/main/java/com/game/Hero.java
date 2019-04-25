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
        playerX = field.getFieldHeight() - 1;
        playerY = field.getFieldWidth() / 2 - 1;
        field.setNeedField(playerX, playerY, 'X');
    }

    public void playerAction(Object action) {
        if (action.equals("Left")) moveLeft();
        if (action.equals("Right")) moveRight();
        if (action.equals("Up")) moveUp();
        if (action.equals("Down")) moveDown();

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
