package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

    Game game = new Game("Ace", "Bob");

    @Test
    public void love_all() {
        assertEquals("Love All", game.score());
    }

    @Test
    public void fifteen_love() {
        givenFirstPlayerScore(1);
        scoreShouldBe("Fifteen Love");
    }

    @Test
    public void thirty_love() {
        givenFirstPlayerScore(2);
        scoreShouldBe("Thirty Love");
    }

    @Test
    public void forty_love() {
        givenFirstPlayerScore(3);
        scoreShouldBe("Forty Love");
    }

    @Test
    public void love_fifteen() {
        givenSecondPlayerScore(1);
        scoreShouldBe("Love Fifteen");
    }

    @Test
    public void love_thirty() {
        givenSecondPlayerScore(2);
        scoreShouldBe("Love Thirty");
    }

    @Test
    public void love_forty() {
        givenSecondPlayerScore(3);
        scoreShouldBe("Love Forty");
    }

    @Test
    public void fifteen_All() {
        givenFirstPlayerScore(1);
        givenSecondPlayerScore(1);
        scoreShouldBe("Fifteen All");
    }


    @Test
    public void ace_win_4_0() {
        givenFirstPlayerScore(4);
        scoreShouldBe("Ace win");
    }

    @Test
    public void bob_win_0_4() {
        givenSecondPlayerScore(4);
        scoreShouldBe("Bob win");
    }

    @Test
    public void deuce_3_3() {
        givenFirstPlayerScore(3);
        givenSecondPlayerScore(3);
        scoreShouldBe("Deuce");
    }

    @Test
    public void ace_adv() {
        givenFirstPlayerScore(4);
        givenSecondPlayerScore(3);
        scoreShouldBe("Ace Adv");
    }



    private void givenFirstPlayerScore(int score) {
        for (int i = 0; i < score; i++) {
            game.firstPlayerScores();
        }
    }

    private void givenSecondPlayerScore(int score) {
        for (int i = 0; i < score; i++) {
            game.secondPlayerScores();
        }
    }

    private void scoreShouldBe(String score) {
        assertEquals(score, game.score());
    }

}
