package com.game;

public class Pistol {
    private int pistolX;
    private int pistolY;
    private static int count;
    private Hero hero;
    private BattleField field;

    public Pistol(Hero hero, BattleField field) {
        this.hero = hero;
        this.field = field;
    }

    public void shotPistol() {
        if (count == 0) {
            field.setNeedField(pistolX,pistolY,' ');
            pistolX = hero.getPlayerX() - 1;
            pistolY = hero.getPlayerY();
            count++;
            field.setNeedField(pistolX,pistolY,'*');
        }
        else{
            pistolX--;
            field.setNeedField(pistolX,pistolY,'*');

        }

    }
}
