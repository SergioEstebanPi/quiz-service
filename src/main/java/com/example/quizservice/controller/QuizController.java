package com.example.quizservice.controller;

import com.example.quizservice.model.QuestionWrapper;
import com.example.quizservice.model.Response;
import com.example.quizservice.service.QuizService;
import com.example.quizservice.model.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizdto){
        return quizService.createQuiz(quizdto.getCategoryName(),
                quizdto.getNumQuestions(),
                quizdto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,
                                              @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
