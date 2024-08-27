package com.QuizApp.QuizBackEndApplication.WebLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizApp.QuizBackEndApplication.Model.questions;
import com.QuizApp.QuizBackEndApplication.Service.DataProvidingMethods;

import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/questions")
public class MainController {
	@Autowired
	DataProvidingMethods   methods;
	 
	@GetMapping("/allQuestions")
	public ResponseEntity<List<questions>> getAllQuestions(){
		return new ResponseEntity<List<questions>>(methods.getallquestions(),HttpStatus.ACCEPTED);
	}

	@GetMapping("/catagiroy/{cat}")
	public ResponseEntity<List<questions>> getquestionsbyCat(@PathVariable String cat){
		
		return new ResponseEntity<List<questions>>(methods.getbycat(cat),HttpStatus.OK);
	}
	
	@PostMapping("/addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody questions question){
		return  new ResponseEntity<String>( methods.addquestion(question),HttpStatus.ACCEPTED);
	}
}
