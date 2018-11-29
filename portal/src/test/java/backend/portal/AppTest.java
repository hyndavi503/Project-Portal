package backend.portal;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import backend.portal.HibernateConfig;
import backend.portal.model.Admin;
import backend.portal.model.Comment;
import backend.portal.model.PostBlogs;

import backend.portal.model.User;
import backend.portal.model.dao.AdminDao;
import backend.portal.model.dao.PostBlogsDao;

import backend.portal.model.dao.UserDao;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@SpringJUnitConfig(classes = (HibernateConfig.class))
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest 
    
{
    
	@Autowired
	private UserDao userDao;
	@Autowired
	private User user;
	@Autowired
	private PostBlogs postBlogs;
	@Autowired
	private PostBlogsDao postBlogsDao;
	
	@Autowired
	private Admin admin;
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private Comment commment;
	
	@Before
	public void setup() 
	{
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		user.setName("hyndavi");
		user.setEmail("hyndavi@gmail.com");
		user.setMobile("9966293705");
		user.setPassword("hyndavi");
		user.setRole("faculty");
			
		
		postBlogs.setPostDescription("hello");
		postBlogs.setPostTitle("messaage");
	}
	
	@org.junit.Test
	public void addUser()
	{
		assertEquals("test is failed",true,userDao.registerUser(user));
		
	}
	
	
	public void addPost()
	{
		assertEquals("test is failed",true,postBlogsDao.addPost(postBlogs));
	}
	
	public void getUserByEmail()
	{
		userDao.registerUser(user);
		assertEquals("test is failed",user,userDao.getUserByEmail(user.getEmail()));
	}
	@After
	public void deleteUser()
	{
		userDao.deleteUser(user);
	}

	
	public void deletePost()
	{
		postBlogsDao.deletePost(postBlogs);
	}
	
}
