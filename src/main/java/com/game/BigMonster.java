package com.game;

import java.util.Random;

public class BigMonster {
    private BattleField field;
    int bigMonsterX;
    int bigMonsterY;
    char view = 'B';

    public BigMonster(BattleField field) {
        this.field = field;
        Random random = new Random();
        bigMonsterX = random.nextInt(4)+3;
        bigMonsterY = random.nextInt(field.getFieldWidth());
        field.setNeedField(bigMonsterX, bigMonsterY, view);
    }

    public void moveBigMonster() {
        Random random = new Random();
        int x = bigMonsterX;
        int y = bigMonsterY;
        if (field.fieldChar(x, y) != 'X')
            field.setNeedField(x, y, ' ');

        int a = x, b = y, c;
        c = random.nextInt(10);
        if (c % 2 == 0)
            a = field.moveRandomUpDown(bigMonsterX);
        else
            b = field.moveRandomLeftRight(bigMonsterY);

        if (field.fieldChar(a, b) == ' ' || field.fieldChar(a, b) == 'X'|| field.fieldChar(a, b) == 'T') {
            bigMonsterX = a;
            bigMonsterY = b;
            field.setNeedField(a, b, view);
        } else {
            field.setNeedField(x, y, view);
        }

    }

    public int getBigMonsterX() {
        return bigMonsterX;
    }

    public int getBigMonsterY() {
        return bigMonsterY;
    }

    public char getView() {
        return view;
    }

    public void setView(char view) {
        this.view = view;
    }
}
