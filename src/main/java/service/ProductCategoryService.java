package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductCategoryDAO;
import entity.ProductCategory;

@Service("productCategoryService")
public class ProductCategoryService {

	@Autowired
	ProductCategoryDAO productCategoryDAO;
	
	@Transactional
	public List<ProductCategory> getAllProductCategory(){
		return productCategoryDAO.getAllProductCategory();
	}
}
