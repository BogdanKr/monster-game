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
        Hero superman = new Hero(field);

        SimpleEngine simpleEngine = new SimpleEngine(field, monster, console, superman);
        simpleEngine.runGame();

    }
}

