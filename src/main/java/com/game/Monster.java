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

    public void setMonsterX(int monsterX) {
        this.monsterX = monsterX;
    }

    public int getMonsterY() {
        return monsterY;
    }

    public void setMonsterY(int monsterY) {
        this.monsterY = monsterY;
    }


}
