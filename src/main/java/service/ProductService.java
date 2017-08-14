package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDAO;
import entity.Product;

@Service("productService")
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	@Transactional
	public List<Product> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Transactional
	public List<Product> getProductByCategory(Integer product_category) {
		return productDAO.getProductByCategory(product_category);
	}

	@Transactional
	public List<Product> getProductById(Integer id) {
		return productDAO.getProductById(id);
	}

	@Transactional
	public List<Product> getProductByCategoryAndPage(Integer product_category, Integer firstResult, Integer maxResult) {
		return productDAO.getProductByCategoryAndPage(product_category, firstResult, maxResult);
	}
}
