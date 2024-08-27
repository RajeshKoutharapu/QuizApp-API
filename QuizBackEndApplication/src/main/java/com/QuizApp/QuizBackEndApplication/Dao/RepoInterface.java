package com.QuizApp.QuizBackEndApplication.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApp.QuizBackEndApplication.Model.questions;

public interface RepoInterface extends JpaRepository<questions, Integer> {
	
	public List<questions> findByTopic(String topic);

}
