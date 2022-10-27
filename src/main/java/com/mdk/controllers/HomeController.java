package com.mdk.controllers;

import com.mdk.models.Product;
import com.mdk.models.User;
import com.mdk.service.IProductService;
import com.mdk.service.IStoreService;
import com.mdk.service.IUserService;
import com.mdk.service.impl.ProductService;
import com.mdk.service.impl.StoreService;
import com.mdk.service.impl.UserService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStoreService storeService = new StoreService();
		IUserService userService = new UserService();
		IProductService productService = new ProductService();

//		Product product = new Product();
//		product.setId(1L);
//		product.setName("Truyen tranh");
//		product.setDescription("Danh cho tre em");
//		product.setPrice(BigDecimal.valueOf(700));
//		product.setPromotionalPrice(BigDecimal.valueOf(300));
//		product.setQuantity(7);
//		product.setSold(5);
//		product.setCategoryId(1L);
//		productService.update(product);

		productService.totalProductByStore(1);
	}
}
