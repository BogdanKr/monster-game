package com.game;

import jline.console.ConsoleReader;
import jline.console.KeyMap;

import java.io.IOException;

public class SimpleEngine {
    private BattleField field;
    private Monster[] monster;
    private ConsoleReader console;
    private Hero hero;
    private Pistol pistol;

    public SimpleEngine(BattleField field, Monster[] monster, ConsoleReader console, Hero hero) {
        this.field = field;
        this.monster = monster;
        this.console = console;
        this.hero = hero;
    }

    public void runGame() throws IOException {
        for (int i = 0; i < monster.length; i++) {
            monster[i] = new Monster(field);
        }
        pistol = new Pistol(field);
        console.clearScreen();
        console.println(field.viewBattleField());
        console.flush();
        int shot = 0;

        while (checkAlive()) {
            KeyMap map = new KeyMap("");
            map.bind("\u001B[A", "Up");
            map.bind("\u001B[B", "Down");
            map.bind("\u001B[C", "Right");
            map.bind("\u001B[D", "Left");
            map.bind(" ", "Shot");
            Object action = console.readBinding(map);
            hero.playerAction(action);

            //перемещае монстров
            for (int i = 0; i < monster.length; i++) {
                monster[i].moveMonster();
            }

            if (shot > 0) pistol.shooting();//полет пули если был выстрел

            //новый выстрел если небыло предыдущего
            if (action.equals("Shot")) {
                if (shot == 0) {
                    pistol.shotPistol(hero.getPlayerX(), hero.getPlayerY());
                    shot++;
                }
            }

            //проверяю попала ли пуля в монстра если да удаляю его
            for (int i = 0; i < monster.length; i++) {
                if (monster[i].getMonsterX() == pistol.getPistolX() && monster[i].getMonsterY() == pistol.getPistolY()) {
                    monsterDied(i);
                    field.setNeedField(pistol.getPistolX(), pistol.getPistolY(), 'T');
                    shot = 0;
                    pistol.pistolHit(hero.getPlayerX(), hero.getPlayerY());
                }
            }

            console.clearScreen();
            console.println(field.viewBattleField());
            console.flush();

            if (pistol.getPistolX() == 0) {
                shot = 0;//если пуля долетела до конца поля, полет прекращается
                field.setNeedField(pistol.getPistolX(), pistol.getPistolY(), ' ');
            }
        }

    }

    public boolean checkAlive() throws IOException {
        for (int i = 0; i < monster.length; i++) {

            if (monster[i].getMonsterX() == hero.getPlayerX() && monster[i].getMonsterY() == hero.getPlayerY()) {
                field.setNeedField(hero.getPlayerX(), hero.getPlayerY(), 'D');
                console.clearScreen();
                console.println(field.viewBattleField());
                console.flush();
                console.println("GAME OVER - monsters killed you");
                console.flush();
                return false;
            }
        }
        if (monster.length == 0) {
            console.clearScreen();
            console.println(field.viewBattleField());
            console.flush();
            console.println("Congratulations!!!!  YOU  WIN!!!!");
            console.flush();
            return false;
        }

        return true;
    }

    public void monsterDied(int x) {
        Monster[] monsterNew = new Monster[monster.length - 1];
        for (int i = 0; i < x; i++) {
            monsterNew[i] = monster[i];
        }
        for (int i = x + 1; i < monster.length; i++) {
            monsterNew[i - 1] = monster[i];
        }
        monster = monsterNew;
    }
}