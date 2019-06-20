package com.game;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BattleFieldTest {
    @Test
    public void test1(){
        BattleField battleField = new BattleField(10,15);

        assertEquals(10, battleField.getFieldHeight());
        assertEquals(15, battleField.getFieldWidth());

        battleField.setNeedField(1,1,'X');
        assertEquals('X',battleField.fieldChar(1,1));

        assertEquals(2,battleField.moveRight(1,1,'X'));
        assertEquals(2,battleField.moveLeft(1,3,'X'));
    }
}
