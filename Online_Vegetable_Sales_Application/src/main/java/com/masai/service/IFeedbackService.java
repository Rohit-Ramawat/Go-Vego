package com.masai.service;

import java.util.List;

import com.masai.entity.Feedback;



public interface IFeedbackService {
	
	public Feedback addFeedback(Feedback feedback);
	public List<Feedback> viewAllFeedbacks(int vegId);
	public List<Feedback> viewFeedback(int customerId);
}
