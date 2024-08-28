package com.QuizApp.QuizBackEndApplication.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizApp.QuizBackEndApplication.Dao.RepoInterface;
import com.QuizApp.QuizBackEndApplication.Model.coustomQuiz;
import com.QuizApp.QuizBackEndApplication.Model.questions;

@Service
public class DataProvidingMethods {
     @Autowired
	RepoInterface repo;
     
     public List<questions> getallquestions(){
    	 
    	 return repo.findAll();
     }

	public List<questions> getbycat(String cat) {
		// TODO Auto-generated method stub
		
		return repo.findByTopic(cat);
	}

	public String  addquestion(questions question) {
		// TODO Auto-generated method stub
		  questions res =repo.save(question);
		return (res!=null)?"Added SuccesFully":"incorect data Format";
	}

	public List<coustomQuiz> getcoustomquiz(String cat, Integer num) {
		// TODO Auto-generated method stub
		List<questions> list= repo.findQuestionsBynumber(cat, num);
		List<coustomQuiz> clist=new ArrayList<>();
		for(questions c:list) {
			coustomQuiz cm=new coustomQuiz(c.getId(),c.getDificulty(),c.getQuestion(),c.getOption1(),c.getOption2(),c.getOption3(),c.getOption4(),c.getTopic());
			clist.add(cm);
	}
		return clist;
	}

	public Integer validation(List<Integer> id, List<String> ans) {
		// TODO Auto-generated method stub
		int i=0;
		int right=0;
		for(Integer n:id) {
	     String res=repo.FindRightAnswers(n);
	       if(res.equals(ans.get(i)))
	    	  right++;
	       
	       System.out.println(res+" "+ans.get(i));
	       i++;
		}
		return right;
	}
	
}
