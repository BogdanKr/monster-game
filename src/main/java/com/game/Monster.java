package com.game;

import java.util.Random;

public class Monster {
    private BattleField field;
    int monsterX;
    int monsterY;


    Monster(BattleField field) {
        Random random = new Random();
        this.field = field;
        monsterX = random.nextInt(3);
        monsterY = random.nextInt(field.getFieldWidth());
        field.setNeedField(monsterX, monsterY, 'M');
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
        if (c % 2 == 0) {
            if (x > 0 && x < field.getFieldHeight() - 1)
                a = x + random.nextInt(3) - 1;
            else if (x == 0) a = x + random.nextInt(2);
            else a = x - random.nextInt(2);
        } else {
            if (y > 0 && y < field.getFieldWidth() - 1)
                b = y + random.nextInt(3) - 1;
            else if (y == 0) b = y + random.nextInt(2);
            else b = y - random.nextInt(2);
        }

        if (field.fieldChar(a, b) == ' ' || field.fieldChar(a, b) == 'X') {
            monsterX = a;
            monsterY = b;
            field.setNeedField(a, b, 'M');
        } else {
            field.setNeedField(x, y, 'M');
        }

    }
}

