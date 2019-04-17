package com.game;

import jline.console.ConsoleReader;
import jline.console.KeyMap;

import java.io.IOException;
import java.util.Random;


public class Move {
    private Object action;
    private final ConsoleReader console;
    private BattleField player;
    private Monster[] monster;

    public Move(KeyMap map, ConsoleReader console) throws IOException {
        this.console = console;
        action = console.readBinding(map);
    }

    public void setPlayer(BattleField player) {
        this.player = player;
    }

    public void playerAction() {
        if (action.equals("Left")) moveLeft();
        if (action.equals("Right")) moveRight();
        if (action.equals("Up")) moveUp();
        if (action.equals("Down")) moveDown();

    }

    public void moveLeft() {
        int i = player.getPlayerX();
        int j = player.getPlayerY();
        if (j > 0) {
            if (i == player.getFieldHeight() - 1) {
                j--;
                player.setPlayerY(j);
                player.setNeedField(i, j + 1, '_');
            } else {
                j--;
                player.setPlayerY(j);
                player.setNeedField(i, j + 1, ' ');
            }
        }
    }

    public void moveRight() {
        int i = player.getPlayerX();
        int j = player.getPlayerY();
        if (j < player.getFieldWidth() - 1) {
            if (i == player.getFieldHeight() - 1) {
                j++;
                player.setPlayerY(j);
                player.setNeedField(i, j - 1, '_');
            } else {
                j++;
                player.setPlayerY(j);
                player.setNeedField(i, j - 1, ' ');
            }
        }
    }

    public void moveDown() {
        int i = player.getPlayerX();
        int j = player.getPlayerY();
        if (i < player.getFieldHeight() - 1) {
            i++;
            player.setPlayerX(i);
            player.setNeedField(i - 1, j, ' ');
        }
    }

    public void moveUp() {
        int i = player.getPlayerX();
        int j = player.getPlayerY();
        if (i > 0) {
            if (i == player.getFieldHeight() - 1) {
                i--;
                player.setPlayerX(i);
                player.setNeedField(i + 1, j, '_');
            } else {
                i--;
                player.setPlayerX(i);
                player.setNeedField(i + 1, j, ' ');
            }
        }
    }

    public void moveMonster(Monster[] monster) {
        Random random = new Random();
        this.monster = monster;
        for (int i = 0; i < monster.length; i++) {
            int x = monster[i].getMonsterX();
            int y = monster[i].getMonsterY();
            player.setNeedField(x, y, ' ');
            if (x > 0 && x < player.getFieldHeight() - 1)
                x = x + random.nextInt(3) - 1;
            else if (x == 0) x = x + random.nextInt(2);
            else x = x - random.nextInt(2);
            if (y > 0 && y < player.getFieldWidth() - 1)
                y = y + random.nextInt(3) - 1;
            else if (y == 0) y = y + random.nextInt(2);
            else y = y - random.nextInt(2);

            monster[i].setMonsterX(x);
            monster[i].setMonsterY(y);
            player.setNeedField(x, y, 'M');
        }
    }
}

