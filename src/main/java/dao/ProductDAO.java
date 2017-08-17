package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Product;

@Service("productService")
@Repository
public class ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Integer pageSize = 10, pageNumber = 0;
	
	

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getAllProduct() {
		List<Product> products = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(pageNumber);
			criteria.setMaxResults(pageSize);
			products = criteria.list();
			
			Criteria criteriaCount = session.createCriteria(Product.class);
			criteriaCount.setProjection(Projections.rowCount());
			Long countResults = (Long) criteriaCount.uniqueResult();
			int lastPageNumber = (int) (Math.ceil(countResults / pageSize));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getProductByCategory(Integer product_category) {
		List<Product> products = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from Product where product_category = :product_category");
			query.setParameter("product_category", product_category);
			products = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getProductById(Integer id) {
		List<Product> product = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from Product where id = :id");
			query.setParameter("id", id);
			product = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Transactional
	public Boolean addProduct(String name, Integer product_category, String image, String description, Double price) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product product = new Product(name, product_category, image, description, price);
			session.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean updateProduct1(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean updateProduct(Integer id, String name, Integer product_category, String image, String description,
			Double price) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product product = new Product(name, product_category, image, description, price);
			product.setId(id);
			session.saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean removeProduct(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product product = (Product) session.load(Product.class, id);
			session.delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
