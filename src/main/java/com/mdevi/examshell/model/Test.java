package com.mdevi.examshell.model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
    private List<Question> questionList;

    public Test() {
    }

    public Test(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Test{" +
                "questionList=" + questionList +
                '}';
    }
}
