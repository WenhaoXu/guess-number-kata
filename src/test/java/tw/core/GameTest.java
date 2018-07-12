package tw.core;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @BeforeEach
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }


    @Test
    public void should_get_the_success_status_when_guess_input_is_correct() throws Exception {

        //given
//        excuteSuccessGuess();
        GuessResult guess = game.guess(Answer.createAnswer("1 2 3 4"));
        //when
        //then
        assertThat(guess.getResult(), is("4A0B"));
    }

    @Test
    public void should_the_guess_history_size_1_when_guess_input_one() throws Exception {

        //given
//        excuteSuccessGuess();
        GuessResult guess = game.guess(Answer.createAnswer("1 5 3 4"));
//        guess = game.guess(Answer.createAnswer("1 6 3 4"));
        //when
        //then


        assertThat(game.guessHistory().size(), is(1));
    }


}
