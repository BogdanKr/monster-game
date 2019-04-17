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
            move.moveMonster(monster);

//            //проверяю не наткнулся ли человек на монтра
//            if ((x == i && y == j) || (a == i && b == j)) {
//                consoleReader.println("GAME OVER");
//                consoleReader.flush();
//                break;
//            }

//            //пермещаю рэндом монстра1
//            position[x][y] = ' ';
//            if (x > 0)
//                x = x + random.nextInt(3) - 1;
//            else x = x + random.nextInt(2);
//            if (y > 0 && y < 9)
//                y = y + random.nextInt(3) - 1;
//            else if (y == 0) y = y + random.nextInt(2);
//            else y = y - random.nextInt(2);
//            position[x][y] = 'M';
//
//            //пермещаю рэндом монстра2
//            position[a][b] = ' ';
//            if (a > 0)
//                a = a + random.nextInt(3) - 1;
//            else a = a + random.nextInt(2);
//            if (b > 0 && b < 9)
//                b = b + random.nextInt(3) - 1;
//            else if (b == 0) b = b + random.nextInt(2);
//            else b = b - random.nextInt(2);
//            position[a][b] = 'M';

            consoleReader.clearScreen();
            field.viewBattleField();

//            consoleReader.println("GoGoGoooo");
//            for (int k = 0; k < 13; k++) {
//                consoleReader.println(Arrays.toString(position[k]));
//            }
            consoleReader.flush();

//            //проверяю не наткнулся ли монстр на человека
//            if ((x == i && y == j) || (a == i && b == j)) {
//                consoleReader.println("GAME OVER");
//                consoleReader.flush();
//                break;
        }
    }
}

