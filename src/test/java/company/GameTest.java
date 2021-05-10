package test.java.company;

import main.java.company.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    @Test
    public void calculateScoreNoSparesNoStrikes(){
        assertEquals(60, game.calculateScore("12345123451234512345"));
    }

    @Test
    void calculateScoreOnly1And2() {
        assertEquals(30, game.calculateScore("12121212121212121212"));
    }

    @Test
    void calculateScoreHeartbreak() {
        assertEquals(90, game.calculateScore("9-9-9-9-9-9-9-9-9-9-"));
    }

    @Test
    void calculateScoreAbsoluterLoser() {
        assertEquals(0, game.calculateScore("--------------------"));
    }

    @Test
    void calculateScorePerfectGame() {
        assertEquals(300, game.calculateScore("xxxxxxxxxxxx"));
    }

    @Test
    void calculateScoreSpareEveryRound() {
        assertEquals(150, game.calculateScore("5/5/5/5/5/5/5/5/5/5/5"));
    }

    @Test
    void calculateScoreSomeSpares() {
        assertEquals(123, game.calculateScore("5/5/5/515/515/5/5/51"));
    }

    @Test
    void calculateScoreSpareSometimes() {
        assertEquals(116, game.calculateScore("525/5/525/5/525-5/5/5"));
    }

    @Test
    void calculateScoreSomeStrikes() {
        assertEquals(60, game.calculateScore("1212x12121212x12x12"));
    }

    @Test
    void calculateScoreSpareAndStrikesAndNormalValues() {
        assertEquals(118, game.calculateScore("1-12x2/-/2127x1/x1/"));
    }
}