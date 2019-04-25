package com.game;

import jline.console.ConsoleReader;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleReader console = new ConsoleReader();
        console.clearScreen();

        // создаю поле 13 / 6 и заполняю его пробелами, снизу поле подчеркнуто и по центру герой
        BattleField field = new BattleField(13, 6);
        Monster[] monster = new Monster[10]; //создаю монстров и их количество
        BigMonster[] bigMonster = new BigMonster[10];//создаю сильных монстров, умирают после двух попаданий
        Monster2 [] monster2 = new Monster2[5];
        Hero superman = new Hero(field);

        SimpleEngine simpleEngine = new SimpleEngine(field, monster, monster2, bigMonster, console, superman);
        simpleEngine.runGame();

    }
}

