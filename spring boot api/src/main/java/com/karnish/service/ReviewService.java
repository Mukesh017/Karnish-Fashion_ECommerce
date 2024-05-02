package com.karnish.service;

import java.util.List;

import com.karnish.exception.ProductException;
import com.karnish.modal.Review;
import com.karnish.modal.User;
import com.karnish.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req, User user) throws ProductException;

	public List<Review> getAllReview(Long productId);

}
