package com.mdevi.examshell.model;

import java.io.Serializable;

public class Question implements Serializable {
    private String number;
    private String text;
    private String answer;
    private String locale;

    public Question(String number, String text, String answer, String locale) {
        this.number = number;
        this.text = text;
        this.answer = answer;
        this.locale = locale;
    }

    public Question() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Question{" +
                "number=" + number +
                ", text='" + text + '\'' +
                '}';
    }
}
