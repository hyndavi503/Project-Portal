package backend.portal.model.dao;

import backend.portal.model.Admin;

public interface AdminDao 
{

	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(Admin admin);
	public Admin adminLogin(String adminemail,String adminpassword);
	
	
	
}
