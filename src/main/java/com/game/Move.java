package com.game;

import jline.console.ConsoleReader;
import jline.console.KeyMap;

import java.io.IOException;
import java.util.Random;


public class Move {
    private Object action;
    private final ConsoleReader console;
    private BattleField field;
    private Monster[] monster;

    public Move(KeyMap map, ConsoleReader console) throws IOException {
        this.console = console;
        action = console.readBinding(map);
    }

    public void setPlayer(BattleField field) {
        this.field = field;
    }

    public void playerAction() {
        if (action.equals("Left")) moveLeft();
        if (action.equals("Right")) moveRight();
        if (action.equals("Up")) moveUp();
        if (action.equals("Down")) moveDown();
        field.setNeedField(field.getPlayerX(), field.getPlayerY(), 'X');
    }

    public void moveLeft() {
        int i = field.getPlayerX();
        int j = field.getPlayerY();
        if (j > 0) {
            if (i == field.getFieldHeight() - 1) {
                j--;
                field.setPlayerY(j);
                field.setNeedField(i, j + 1, '_');
            } else {
                j--;
                field.setPlayerY(j);
                field.setNeedField(i, j + 1, ' ');
            }
        }
    }

    public void moveRight() {
        int i = field.getPlayerX();
        int j = field.getPlayerY();
        if (j < field.getFieldWidth() - 1) {
            if (i == field.getFieldHeight() - 1) {
                j++;
                field.setPlayerY(j);
                field.setNeedField(i, j - 1, '_');
            } else {
                j++;
                field.setPlayerY(j);
                field.setNeedField(i, j - 1, ' ');
            }
        }
    }

    public void moveDown() {
        int i = field.getPlayerX();
        int j = field.getPlayerY();
        if (i < field.getFieldHeight() - 1) {
            i++;
            field.setPlayerX(i);
            field.setNeedField(i - 1, j, ' ');
        }
    }

    public void moveUp() {
        int i = field.getPlayerX();
        int j = field.getPlayerY();
        if (i > 0) {
            if (i == field.getFieldHeight() - 1) {
                i--;
                field.setPlayerX(i);
                field.setNeedField(i + 1, j, '_');
            } else {
                i--;
                field.setPlayerX(i);
                field.setNeedField(i + 1, j, ' ');
            }
        }
    }

    public void moveMonster(Monster[] monster) {
        Random random = new Random();
        this.monster = monster;
        for (int i = 0; i < monster.length; i++) {
            int x = monster[i].getMonsterX();
            int y = monster[i].getMonsterY();
            if (field.fieldChar(x, y) != 'X')
                field.setNeedField(x, y, ' ');
            if (x > 0 && x < field.getFieldHeight() - 1)
                x = x + random.nextInt(3) - 1;
            else if (x == 0) x = x + random.nextInt(2);
            else x = x - random.nextInt(2);
            if (y > 0 && y < field.getFieldWidth() - 1)
                y = y + random.nextInt(3) - 1;
            else if (y == 0) y = y + random.nextInt(2);
            else y = y - random.nextInt(2);

            monster[i].setMonsterX(x);
            monster[i].setMonsterY(y);
            field.setNeedField(x, y, 'M');
        }
    }
}

