package frontend.comment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.portal.model.Admin;
import backend.portal.model.AdminLogin;

import backend.portal.model.User;
import backend.portal.model.dao.AdminDao;
import backend.portal.model.dao.UserDao;

@RestController
@CrossOrigin(origins="*" ,allowedHeaders={"*"})
public class AdminController {

	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;
	
	
	
	@PostMapping("/adminlogin")
	public Admin login(@RequestBody AdminLogin adminlogin)
	{
		 try {
			Admin adminDetails=adminDao.adminLogin(adminlogin.getAdminemail(),adminlogin.getAdminpassword());
			if(adminDetails!=null)
			{
				return adminDetails;
			}
			else
			{
				return null;
			} 
		  }catch(Exception e){
				return null;
			}
	}
	
	
	
	
	
	
	
	
	
	
	
}
