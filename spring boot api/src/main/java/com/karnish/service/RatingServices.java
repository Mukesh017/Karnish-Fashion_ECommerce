package com.karnish.service;

import java.util.List;

import com.karnish.exception.ProductException;
import com.karnish.modal.Rating;
import com.karnish.modal.User;
import com.karnish.request.RatingRequest;

public interface RatingServices {

	public Rating createRating(RatingRequest req, User user) throws ProductException;

	public List<Rating> getProductsRating(Long productId);

}
