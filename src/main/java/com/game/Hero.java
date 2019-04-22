package com.game;

public class Hero {
    private BattleField field;
    private int playerX;
    private int playerY;

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
        field.setNeedField(playerX, playerY, 'X');
    }

    public void moveLeft() {
        if (playerY > 0) {
            if (playerX == field.getFieldHeight() - 1) {
                playerY--;
                field.setNeedField(playerX, playerY + 1, '_');
            } else {
                playerY--;
                field.setNeedField(playerX, playerY + 1, ' ');
            }
        }
    }

    public void moveRight() {
        if (playerY < field.getFieldWidth() - 1) {
            if (playerX == field.getFieldHeight() - 1) {
                playerY++;
                field.setNeedField(playerX, playerY - 1, '_');
            } else {
                playerY++;
                field.setNeedField(playerX, playerY - 1, ' ');
            }
        }
    }

    public void moveDown() {
        if (playerX < field.getFieldHeight() - 1) {
            playerX++;
            field.setNeedField(playerX - 1, playerY, ' ');
        }
    }

    public void moveUp() {
        if (playerX > 0) {
            if (playerX == field.getFieldHeight() - 1) {
                playerX--;
                field.setNeedField(playerX + 1, playerY, '_');
            } else {
                playerX--;
                field.setNeedField(playerX + 1, playerY, ' ');
            }
        }
    }
}
