package com.QuizApp.QuizBackEndApplication.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuizApp.QuizBackEndApplication.Model.coustomQuiz;
import com.QuizApp.QuizBackEndApplication.Model.questions;

public interface RepoInterface extends JpaRepository<questions, Integer> {
	
	public List<questions> findByTopic(String topic);
	

	@Query(value = "SELECT * FROM questions WHERE questions.topic = :cat ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    public List<questions> findQuestionsBynumber(@Param("cat") String cat, @Param("num") Integer num);
    
    @Query(value="SELECT correctanswer from questions where id=:id")
    public String  FindRightAnswers(@Param("id") Integer id);
}
