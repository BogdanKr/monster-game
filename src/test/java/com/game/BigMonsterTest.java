package com.game;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BigMonsterTest {
    @Test
    public void testBigMonster(){
        BigMonster bigMonster = new BigMonster(new BattleField(10,15));
        assertEquals('B', bigMonster.getView());
        assertEquals(bigMonster.bigMonsterX, bigMonster.getBigMonsterX());
        assertEquals(bigMonster.bigMonsterY, bigMonster.getBigMonsterY());
        bigMonster.setView('T');
        assertEquals('T', bigMonster.getView());
    }
}
