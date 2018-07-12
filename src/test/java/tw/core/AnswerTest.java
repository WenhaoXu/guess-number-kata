package tw.core;


import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.GuessNumberModule;
import tw.commands.GuessInputCommand;
import tw.controllers.GameController;

import static com.google.inject.Guice.createInjector;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_retrun_4A0B_when_input_1_2_3_4()throws Exception{
       Answer answer=Answer.createAnswer("1 2 3 4");
       String result=answer.check(answer).getValue();
       assert result.equals("4A0B");
    }

}