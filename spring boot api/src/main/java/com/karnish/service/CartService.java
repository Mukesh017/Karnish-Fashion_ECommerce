package com.karnish.service;

import com.karnish.exception.ProductException;
import com.karnish.modal.Cart;
import com.karnish.modal.CartItem;
import com.karnish.modal.User;
import com.karnish.request.AddItemRequest;

public interface CartService {

	public Cart createCart(User user);

	public CartItem addCartItem(Long userId, AddItemRequest req) throws ProductException;

	public Cart findUserCart(Long userId);

}
