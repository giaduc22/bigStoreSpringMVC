package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Product;

@Repository
@Transactional
public class ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private int pageSize = 10;
	private int page = 0;
	private Long countResults;
	private int lastPageNumber;

	public void setPage(Integer page) {
		this.page = page - 1;
	}

	public int getLastPage() {
		return lastPageNumber;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		List<Product> products = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		List<Product> products = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(page * pageSize);
			criteria.setMaxResults(pageSize);
			products = criteria.list();

			// LAST PAGE CALCULATOR
			Criteria criteria2 = session.createCriteria(Product.class);
			countResults = (Long) criteria2.setProjection(Projections.rowCount()).uniqueResult();
			lastPageNumber = (int) (Math.ceil(countResults / pageSize));				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategory(Integer product_category) {
		List<Product> products = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("product_category", product_category));
			criteria.setFirstResult(page * pageSize);
			criteria.setMaxResults(pageSize);
			products = criteria.list();

			// LAST PAGE CALCULATOR
			Criteria criteria2 = session.createCriteria(Product.class);
			criteria2.add(Restrictions.eq("product_category", product_category));
			countResults = (Long) criteria2.setProjection(Projections.rowCount()).uniqueResult();
			lastPageNumber = (int) (Math.ceil(countResults / pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product getProductById(Integer id) {
		Product product = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("id", id));
			product = (Product) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public Boolean addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean removeProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
