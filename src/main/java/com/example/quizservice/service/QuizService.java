package com.example.quizservice.service;

import com.example.quizservice.dao.QuizDao;
import com.example.quizservice.feign.QuizInterface;
import com.example.quizservice.model.QuestionWrapper;
import com.example.quizservice.model.Quiz;
import com.example.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questionIds = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);

        System.out.println(title);
        System.out.println(questionIds);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        /*
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question question : questionsFromDB){
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),
                    question.getQuestionTitle(),
                    question.getOption1(),
                    question.getOption2(),
                    question.getOption3());
            questionsForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

         */
        return null;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        int right = 0;
        /*
        int i = 0;
        List<Question> questions = quizDao.findById(id).get().getQuestions();
        for (Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);

         */
        return null;
    }
}
