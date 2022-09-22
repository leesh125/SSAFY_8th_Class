package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.model.dao.ProductDAO;
import com.ssafy.sample.model.dto.Product;

public class ProductService {

	private ProductDAO productDAO = new ProductDAO();
	
	public boolean insertProduct(Product product) throws SQLException {
		return productDAO.insertProduct(product) > 0;
	}
	
	public List<Product> getLists() throws SQLException {
		return productDAO.getList();
	}

	public Product getProduct(String code) throws SQLException {
		return productDAO.getProduct(code);
	}
}
