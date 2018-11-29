package backend.portal.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.portal.model.User;
import backend.portal.model.dao.UserDao;





@Component
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory factory;
	
	
	
	public boolean registerUser(User user) {
		try {
			factory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public boolean updateUser(User user) {
		try {
			factory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			factory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public User getUserByEmail(String email) {
		try
		{
			Query<User> query=factory.getCurrentSession().createQuery("from User where email=:email",User.class)
					.setParameter("email", email);
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	public User login(String email, String password) {
		try
		{
		Query<User> query=factory.getCurrentSession().createQuery("from User where email=:email and password=:password",User.class)
				.setParameter("email", email)
				.setParameter("password", password);
		return query.getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return null;
	}
	}

	@Override
	public List<User> getTrainers() {
		try
		{
		Query<User> query=factory.getCurrentSession().createQuery("from User where role='faculty'",User.class);
		// TODO Auto-generated method stub
	
		return query.getResultList();
	}
catch (Exception e) {
	// TODO: handle exception
	return null;
}
}

	@Override
	public User getUserById(int uid) {
		try {
			Query<User> query=factory.getCurrentSession().createQuery("from User where uid=:uid",User.class);
			query.setParameter("uid",uid);
			
			return query.getSingleResult();
		} catch (Exception e) {
			
		return null;
	}
	}
}