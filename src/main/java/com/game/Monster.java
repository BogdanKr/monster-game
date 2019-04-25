package com.game;

import java.util.Random;

public class Monster {
    private BattleField field;
    int monsterX;
    int monsterY;
    char view = 'M';


    Monster(BattleField field) {
        Random random = new Random();
        this.field = field;
        monsterX = random.nextInt(3);
        monsterY = random.nextInt(field.getFieldWidth());
        field.setNeedField(monsterX, monsterY, view);
    }

    public int getMonsterX() {
        return monsterX;
    }

    public int getMonsterY() {
        return monsterY;
    }


    public void moveMonster() {
        Random random = new Random();
        int x = monsterX;
        int y = monsterY;
        if (field.fieldChar(x, y) != 'X')
            field.setNeedField(x, y, ' ');

        int a = x, b = y, c;
        c = random.nextInt(10);
        if (c % 2 == 0)
            a = field.moveRandomUpDown(monsterX);
         else
            b = field.moveRandomLeftRight(monsterY);

        if (field.fieldChar(a, b) == ' ' || field.fieldChar(a, b) == 'X' || field.fieldChar(a, b) == 'T') {
            monsterX = a;
            monsterY = b;
            field.setNeedField(a, b, view);
        } else {
            field.setNeedField(x, y, view);
        }

    }
}

