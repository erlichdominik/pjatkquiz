package com.pjatk.pjatkquiz.quiz.domain


import spock.lang.Specification

class QuizSpecification extends Specification implements QuizSample {
    QuizFacade quizFacade = new QuizConfiguration().quizFacade()
    QuizQueryRepository queryRepository = new QuizConfiguration().quizQueryRepository()

    def "it should add new quiz"() {
        given: "quiz is in the system"
        quizFacade.createQuiz(createQuizCommand)
        expect: "system should return new quiz"
        queryRepository.fetchQuiz(1L).quizName() == createQuizCommand.quizName()
    }

    def "it should add question to existing quiz"() {
        given: "quiz and question is in the system"
        quizFacade.createQuiz(createQuizCommand)
        quizFacade.addQuestionToQuiz(addQuestionToQuizCommand)
        expect: "system returns added question"
        queryRepository.fetchQuiz(1L).questions()[0].questionName() == addQuestionToQuizCommand.questionName()
    }
}
