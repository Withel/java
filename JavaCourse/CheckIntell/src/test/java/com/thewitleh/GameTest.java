package com.thewitleh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game g;

    @BeforeEach
    void init(){
        g = new Game();
    }

    @Test
    void Score_GutterGame_IsCalculatedProperly(){
        int n = 20;
        int pins = 0;

//        for(int i =0 ;i<n; i++){
//            g.roll(pins);
//        }
        rollMany(n, pins);
        Assertions.assertEquals(g.score(), 0);
    }

    private void rollMany(int n, int pins){
        for(int i =0 ;i<n; i++){
            g.roll(pins);
        }
    }

    @Test
    void ScoreAllOnesIsCaculatedProperly() {
//        for(int i =0 ;i<20; i++){
//            g.roll(1);
//        }
        rollMany(20, 1);
        Assertions.assertEquals(g.score(), 20);

    }
}
