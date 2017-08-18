package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	private Integer pageSize = 10;
	private Integer pageNumber;
	private Long countResults;
	private int lastPageNumber;

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPage() {
		return lastPageNumber;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getAllProduct() {
		List<Product> products = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(Product.class);
			if (null != pageNumber) {
				criteria.setFirstResult((pageNumber - 1) * pageSize);
				criteria.setMaxResults(pageSize);
				products = criteria.list();
			} else {
				criteria.setFirstResult(0);
				criteria.setMaxResults(pageSize);
				products = criteria.list();
			}

			criteria.setProjection(Projections.rowCount());
			countResults = (Long) criteria.uniqueResult();
			lastPageNumber = (int) (Math.ceil(countResults / pageSize));
			System.out.println(lastPageNumber);
			System.out.println(countResults);
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
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("product_category", product_category));
			if (null != pageNumber) {
				criteria.setFirstResult((pageNumber - 1) * pageSize);
				criteria.setMaxResults(pageSize);
				products = criteria.list();
			} else {
				criteria.setFirstResult(0);
				criteria.setMaxResults(pageSize);
				products = criteria.list();
			}
			
			criteria.add(Restrictions.eq("product_category", product_category));
			criteria.setProjection(Projections.rowCount());
			countResults = (Long) criteria.uniqueResult();
			lastPageNumber = (int) (Math.ceil(countResults / pageSize));
			System.out.println(countResults);
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
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("id", id));
			product = criteria.list();
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
