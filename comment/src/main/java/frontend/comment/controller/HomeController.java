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

import backend.portal.model.Comment;
import backend.portal.model.Login;
import backend.portal.model.PostBlogs;
import backend.portal.model.User;
import backend.portal.model.dao.CommentDao;
import backend.portal.model.dao.PostBlogsDao;
import backend.portal.model.dao.UserDao;



@RestController
@CrossOrigin(origins="*" ,allowedHeaders={"*"})
public class HomeController {

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PostBlogsDao postBlogsDao;
	@Autowired
	private CommentDao commentDao;
	
	@PostMapping("/register")
	public String register(@RequestBody User user)
	{
		if(userDao.registerUser(user))
		{
			System.out.println(user);
			return "register successful";
		}
		else
		{
			return "registration failed";
		}
	}
	
	
	@PostMapping("/login")
	public User login(@RequestBody Login login)
	{
		System.out.println(login.getEmail()+" "+login.getPassword());
		 try {
			User userDetails=userDao.login(login.getEmail(),login.getPassword());
			if(userDetails!=null)
			{
				return userDetails;
			}
			else
			{
				return null;
			} 
			
		  }
		 catch(Exception e){
				return null;
			}
	}
	

	@GetMapping("/trainerDetails")
	public List<User> getTrainers()
	{
		List<User> trainerDetails =new ArrayList<User>();
		trainerDetails=userDao.getTrainers();
		return trainerDetails;
	}
	
	@GetMapping("/activeuser/{uid}")
	public boolean activateTrainer(@PathVariable("uid") int uid)
	{
		System.out.println(uid);
		User user=userDao.getUserById(uid);
		user.setStatus(true);
		if(userDao.updateUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@GetMapping("/deactiveuser/{uid}")
	public boolean deactivateTrainer(@PathVariable("uid") int uid)
	{
		System.out.println(uid);
		User user=userDao.getUserById(uid);
		user.setStatus(false);
		if(userDao.updateUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@PostMapping("/postblog")
	public String addPost(@RequestBody PostBlogs postBlogs)
	{
		System.out.println(postBlogs.postDescription);
		if(postBlogsDao.addPost(postBlogs))
		{
			System.out.println(postBlogs);
			
			return "post is added";
		}
		else
		{
			return "post is not added";
		}
	}
	
	@GetMapping("/getposts")
	public List<PostBlogs> getAllPosts()
	{
		return postBlogsDao.getAllPosts();
	}
	
	@PostMapping("/addcomment")
	public boolean addComment(@RequestBody Comment comment)
	{
		if(commentDao.addComment(comment))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@GetMapping("/comments/{postId}")
    public List<Comment> getComments(@PathVariable("postId")int postId){
        
        System.out.println(postId);
        List<Comment> comments= commentDao.getCommentsByPostId(postId);
        System.out.println(comments);
        
        return comments;
    }

	
	@GetMapping("/profile/{uid}")
	public User profile(@PathVariable("uid") int uid)
	{
		User userProfile=userDao.getUserById(uid);
		if(userProfile!=null)
		{
			return userProfile;
		}
		else
			
		{
			return null;
		}
	}
}

