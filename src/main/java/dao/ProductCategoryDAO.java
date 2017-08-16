package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.ProductCategory;

@Service("productCategoryService")
@Repository
public class ProductCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductCategory> getAllProductCategory() {
		List<ProductCategory> productCategories = null;
		Session session = this.sessionFactory.getCurrentSession();
		try {
			productCategories = session.createQuery("from ProductCategory").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategories;
	}

	@Transactional
	public Boolean addProductCategory(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			ProductCategory productCategory = new ProductCategory(name);
			session.save(productCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean updateProductCategory(Integer id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			ProductCategory productCategory = (ProductCategory) session.load(ProductCategory.class, id);
			productCategory.setName(name);
			session.saveOrUpdate(productCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean removeProductCategory(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			ProductCategory productCategory = (ProductCategory) session.load(ProductCategory.class, id);
			session.delete(productCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
