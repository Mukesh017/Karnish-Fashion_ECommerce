package com.karnish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karnish.exception.ProductException;
import com.karnish.exception.UserException;
import com.karnish.modal.Cart;
import com.karnish.modal.CartItem;
import com.karnish.modal.User;
import com.karnish.request.AddItemRequest;
import com.karnish.response.ApiResponse;
import com.karnish.service.CartService;
import com.karnish.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private CartService cartService;
	private UserService userService;

	public CartController(CartService cartService, UserService userService) {
		this.cartService = cartService;
		this.userService = userService;
	}

	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException {

		User user = userService.findUserProfileByJwt(jwt);

		Cart cart = cartService.findUserCart(user.getId());

		System.out.println("cart - " + cart.getUser().getEmail());

		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException {

		User user = userService.findUserProfileByJwt(jwt);

		CartItem item = cartService.addCartItem(user.getId(), req);

		ApiResponse res = new ApiResponse("Item Added To Cart Successfully", true);

		return new ResponseEntity<>(item, HttpStatus.ACCEPTED);

	}

}
