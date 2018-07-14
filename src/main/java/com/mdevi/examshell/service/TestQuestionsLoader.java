package com.mdevi.examshell.service;


import com.mdevi.examshell.model.Question;

import java.util.List;

public interface TestQuestionsLoader {

    List<Question> loadTestQuestions();
}
