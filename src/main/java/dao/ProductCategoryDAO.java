package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductCategory> getAllProductCategory() {
		List<ProductCategory> productCategories = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(ProductCategory.class);
			productCategories = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategories;
	}
	
	@Transactional
	public ProductCategory getCategoryById(Integer id) {
		ProductCategory productCategory = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(ProductCategory.class);
			criteria.add(Restrictions.eq("id", id));
			productCategory = (ProductCategory) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategory;
	}

	@Transactional
	public Boolean addProductCategory(ProductCategory productCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(productCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean updateProductCategory(ProductCategory productCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(productCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean removeProductCategory(ProductCategory productCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(productCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
