package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
       String result=actualAnswer.check(answer).getValue();
       assert result.equals("4A0B");
    }

    @Test
    public void should_retrun_1A0B_when_input_1_5_6_7()throws Exception{
        Answer answer=Answer.createAnswer("1 5 6 7");
        String result=actualAnswer.check(answer).getValue();
//        assert result.equals("1A0B");
        assertThat(result, is("1A0B"));
    }

    @Test
    public void should_retrun_0A2B_when_input_2_4_7_8()throws Exception{
        Answer answer=Answer.createAnswer("2 4 7 8");
        String result=actualAnswer.check(answer).getValue();
//        assert result.equals("1A0B");
        assertThat(result, is("0A2B"));
    }
}