package com.game;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HeroTest {
    @Test
    public void testHero(){
        Hero hero = new Hero(new BattleField(10,15));

        assertEquals(7,hero.getPlayerY());
        assertEquals(9,hero.getPlayerX());
    }
}
