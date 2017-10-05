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

import entity.Category;


@Service("productCategoryService")
@Repository
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> getAllProductCategory() {
		List<Category> productCategories = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Category.class);
			productCategories = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategories;
	}
	
	@Transactional
	public Category getCategoryById(Integer id) {
		Category productCategory = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.eq("id", id));
			productCategory = (Category) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategory;
	}

	@Transactional
	public Boolean addProductCategory(Category productCategory) {
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
	public Boolean updateProductCategory(Category productCategory) {
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
	public Boolean removeProductCategory(Category productCategory) {
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
