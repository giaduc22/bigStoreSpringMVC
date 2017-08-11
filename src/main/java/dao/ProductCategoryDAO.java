package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.ProductCategory;

@Repository
public class ProductCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ProductCategory> getAllProductCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProductCategory> productCategories = session.createQuery("from ProductCategory").list();
		return productCategories;
	}
}
