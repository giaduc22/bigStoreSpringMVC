package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Product;
import entity.ProductCategory;

@Repository
public class ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> getAllProduct() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		return products;
	}

	@Transactional
	public List<Product> getProductByCategory(Integer product_category) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where product_category = :product_category");
		query.setParameter("product_category", product_category);
		List<Product> products = query.list();
		return products;
	}

	@Transactional
	public List<Product> getProductById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where id = :id");
		query.setParameter("id", id);
		List<Product> product = query.list();
		return product;
	}
}
