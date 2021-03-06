package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;

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
       Record record=actualAnswer.check(answer);
       assert record.getValue().equals("4A0B");
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

    @Test
    public void should_retrun_1A2B_when_input_0_3_2_4()throws Exception{
        Answer answer=Answer.createAnswer("0 3 2 4");
        String result=actualAnswer.check(answer).getValue();
//        assert result.equals("1A0B");
        assertThat(result, is("1A2B"));
    }

    @Test
    public void should_retrun_0A0B_when_input_5_6_7_8()throws Exception{
        Answer answer=Answer.createAnswer("5 6 7 8");
        String result=actualAnswer.check(answer).getValue();
//        assert result.equals("1A0B");
        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_return_wrong_input_when_input_1_1_2_3(){
        try
        {    Answer answer=Answer.createAnswer("1 1 2 3");
            answer.validate();
            fail("should return wrong");
        }
        catch (AnswerFormatIncorrectException  exception){

        }
    }

    @Test
    public void should_run_input_when_input_1_5_2_3(){
        try
        {    Answer answer=Answer.createAnswer("1 5 2 3");
            answer.validate();

        }
        catch (AnswerFormatIncorrectException  exception){
            fail("should return right");
        }
    }

    @Test
    public void should_retrun_1_when_input_0_3_2_4_create_right_answer()throws Exception{
        Answer answer=Answer.createAnswer("0 3 2 4");
//        String result=actualAnswer.check(answer).getValue();
//        assert result.equals("1A0B");
        assertThat(answer.toString(), is("0 3 2 4"));
    }

    @Test
    public void should_answer_getIndexOfNum_retrun_1_when_input_0_3_2_4_()throws Exception{
        Answer answer=Answer.createAnswer("0 3 2 4");
//        String result=actualAnswer.check(answer).getValue();
//        assert result.equals("1A0B");
        assertThat(answer.getIndexOfNum("3"), is(1));
    }
}