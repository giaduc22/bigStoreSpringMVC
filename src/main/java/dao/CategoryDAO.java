package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Category;

@Repository
@Transactional
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		List<Category> categories = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Category.class);
			categories = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	public Category getCategoryById(Integer id) {
		Category category = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.eq("id", id));
			category = (Category) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	public Boolean addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean removeCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
