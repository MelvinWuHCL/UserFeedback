package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;


@Controller
public class TestFormController {

	@Autowired
	FeedbackService fbs;
	
	 @GetMapping(value="/testform")
     public Iterable<Feedback> showTestForm(ModelMap model) {
		 //TODO: Create a JSP called "testformjsp.jsp"  
		 return fbs.GetAllFeedback();
     }
	 
	 /*
	@PostMapping("/testform")
	//@RequestParam(value="user") String userName, 
	//@RequestParam(value="rating") int userRating, @RequestParam(value="comment") String userComment
	//ModelMap model,
	 public Feedback submitTestForm( @RequestBody Feedback fb) {
		
		return fbs.addFeedback(fb);
		
		// TODO: implement form submission
		// TODO: add View JSP
		// TODO: Call RestTemplate and make POST json request to localhost:8090/feedback
		 
	 }
	*/
}
