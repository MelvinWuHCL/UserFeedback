package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping(value = "/feedback", produces = "application/json")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.GetAllFeedback();
    }
	
	@PostMapping(value = "/feedback", consumes ={"application/json", "application/x-www-form-urlencoded"})
	
	//@RequestBody Feedback newFeedback
	public String addNewFeedback(@RequestParam(value="user") String userName, 
			@RequestParam(value="rating") int userRating, @RequestParam(value="comment") String userComment) {
		// TODO: Do something useful here.  
		// Add the Feedback.
		//System.out.print("executing add " + newFeedback);
		//return feedbackService.addFeedback(newFeedback);
		if (!userName.isEmpty() && !userComment.isEmpty()) {
			Feedback fb = new Feedback();
			fb.setComments(userComment);
			fb.setRating(userRating);
			fb.setUser(userName);
			feedbackService.addFeedback(fb);
			return "finished";
		}
		
		else return "error";
		 
		
		//return new Feedback();  // Change this.
	}

}
