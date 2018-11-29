
package backend.portal.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.portal.model.Admin;
import backend.portal.model.dao.AdminDao;


@Component
@Transactional
public class AdminDaoImpl implements AdminDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addAdmin(Admin admin) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(admin);
		return true;
		}
		catch (Exception e)
		{
			return false;
			
		}
		
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		try {
			sessionFactory.getCurrentSession().update(admin);
			return true;
		}
		catch (Exception e) 
		{
		return false;
	}
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		try {
			sessionFactory.getCurrentSession().delete(admin);
			return true;
		}
		catch (Exception e) 
		{
		return false;
	}
	}

	@Override
	public Admin adminLogin(String adminemail, String adminpassword) {
		
		try
		{
		Query<Admin> query=sessionFactory.getCurrentSession().createQuery("from Admin where adminemail=:adminemail and adminpassword=:adminpassword",Admin.class);
		query.setParameter("adminemail", adminemail);
		query.setParameter("adminpassword", adminpassword);
		return query.getSingleResult();
		}
		catch (Exception e) {
		return null;
		}
		
	}

	
	
	
}
