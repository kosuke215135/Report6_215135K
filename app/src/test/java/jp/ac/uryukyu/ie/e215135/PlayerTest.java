/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.ac.uryukyu.ie.e215135;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class PlayerTest {
    @Test void checkPlayer() {
        //calcNum()
        Player player = new Player();
        Card card1 = new Card(2, "♤");
        Card card2 = new Card(5, "♡");
        player.setCard(card1);
        player.setCard(card2);
        ArrayList<Integer> listA = new ArrayList<>();
        int ans = player.calcNum(listA);
        assertEquals(7,ans);
        
        // calcMinNum
        Card card3 = new Card(1, "♢");
        player.setCard(card3);
        ans = player.calcMinNum();
        assertEquals(8,ans);
        
        // Aを11で計算するとき
        listA.add(2);
        ans = player.calcNum(listA);
        assertEquals(18,ans);
    }
}
