package com.game;

import jline.console.ConsoleReader;
import jline.console.KeyMap;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.clearScreen();

        // создаю поле 13 / 6 и заполняю его пробелами, снизу поле подчеркнуто и по центру Х
        BattleField field = new BattleField(13, 6, consoleReader);
        Monster[] monster = new Monster[3]; //создаю 3 монстра
        for (int i = 0; i < monster.length; i++) {
            monster[i] = new Monster(field);
        }

        //Вывожу поле до нажатия кнопки
        field.viewBattleField();

        while (true) {
            KeyMap map = new KeyMap("");
            map.bind("\u001B[A", "Up");
            map.bind("\u001B[B", "Down");
            map.bind("\u001B[C", "Right");
            map.bind("\u001B[D", "Left");

            Move move = new Move(map, consoleReader);
            move.setPlayer(field);
            move.playerAction();             //перемещаем клавишами игрока
            move.moveMonster(monster);      //перемещаем монстров


            consoleReader.clearScreen();
            field.viewBattleField();

            //проверям не наткнулись ли монстры на человека
            if (!field.checkAlive(monster)) {
                consoleReader.clearScreen();
                field.viewBattleField();
                consoleReader.println("GAME OVER - monsters killed you");
                consoleReader.flush();
                break;
            }
        }

    }
}

