package com.game;

public class Pistol {
    private int pistolX;
    private int pistolY;
    private int count;
    private BattleField field;

    public Pistol(BattleField field) {
        this.field = field;
        pistolX = field.getFieldHeight() - 1;
        pistolY = field.getFieldWidth() - 1;
    }

    public void shotPistol(int x, int y) {
        if (x > 0) {
            pistolX = x - 1;
            pistolY = y;
            count++;
            field.setNeedField(pistolX, pistolY, '*');
        }
    }

    public void shooting() {
        if (pistolX != 0) {
            field.setNeedField(pistolX, pistolY, ' ');
            pistolX--;
            field.setNeedField(pistolX, pistolY, '*');
        }

    }

    public void pistolHit(int x, int y) {
        count = 0;
        pistolX = x;
        pistolY = y;
    }

    public int getPistolX() {
        return pistolX;
    }

    public int getPistolY() {
        return pistolY;
    }
}
