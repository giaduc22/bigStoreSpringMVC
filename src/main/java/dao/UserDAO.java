package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Login;
import entity.User;


@Service("userService")
@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = null;
		try {
			Query query = session.createQuery("from User");
			users = query.list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return users;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public User auth(Login login) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from User where username = :username and password = :password");
			query.setParameter("username", login.getUsername());
			query.setParameter("password", login.getPassword());
			List<User> users = query.list();
			return users.size() > 0 ? users.get(0) : null;
		} catch (Exception e) {
			return null;
		}
	}

}
