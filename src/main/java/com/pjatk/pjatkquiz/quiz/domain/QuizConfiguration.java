package com.pjatk.pjatkquiz.quiz.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class QuizConfiguration {
    QuizFacade quizFacade() {
        return quizFacade(new InMemoryQuizDatabase());
    }

    @Bean
    QuizFacade quizFacade(QuizRepository quizRepository) {
        return new QuizFacade(quizRepository);
    }

    QuizQueryRepository quizQueryRepository() {
        return quizQueryRepository(new InMemoryQuizDatabase(), new InMemoryQuestionDatabase());
    }

    @Bean
    QuizQueryRepository quizQueryRepository(QuizRepository quizRepository, QuestionRepository questionRepository) {
       return new QuizQueryRepository(quizRepository, questionRepository);
    }

}
