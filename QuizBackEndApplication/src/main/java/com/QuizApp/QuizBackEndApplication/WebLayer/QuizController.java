package com.QuizApp.QuizBackEndApplication.WebLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizApp.QuizBackEndApplication.Model.coustomQuiz;
import com.QuizApp.QuizBackEndApplication.Service.DataProvidingMethods;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	DataProvidingMethods methods;
	
	@GetMapping("/getquiz/{cat}/{num}")
	public ResponseEntity<List<coustomQuiz>> getQuiz(@PathVariable String cat,@PathVariable Integer num){
		
		return new ResponseEntity<List<coustomQuiz>>(methods.getcoustomquiz(cat,num),HttpStatus.CREATED);
	}

}
