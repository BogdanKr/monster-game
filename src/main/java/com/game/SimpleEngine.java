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
        pistol = new Pistol(hero,field);
        console.clearScreen();
        console.println(field.viewBattleField());
        console.flush();

        while (checkAlive()) {
            KeyMap map = new KeyMap("");
            map.bind("\u001B[A", "Up");
            map.bind("\u001B[B", "Down");
            map.bind("\u001B[C", "Right");
            map.bind("\u001B[D", "Left");
            map.bind(" ", "Shot");
            Object action = console.readBinding(map);
            hero.playerAction(action);
            if (action.equals("Shot")) pistol.shotPistol();

            //перемещае монстров
            for (int i = 0; i < monster.length; i++) {
                monster[i].moveMonster();
            }

            console.clearScreen();
            console.println(field.viewBattleField());
            console.flush();
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
        return true;
    }
}