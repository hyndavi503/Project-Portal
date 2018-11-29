package backend.portal.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.portal.model.PostBlogs;
import backend.portal.model.dao.PostBlogsDao;


@Component
@Transactional
public class PostBlogsDaoImpl implements PostBlogsDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addPost(PostBlogs postBlogs) {
		try {
			factory.getCurrentSession().save(postBlogs);
		return true;	
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public PostBlogs getPostByPostId(int postId) 
	{
		try {
			Query<PostBlogs> query=factory.getCurrentSession().createQuery("from PostBlogs where postId=:postId",PostBlogs.class);
			query.setParameter("postId", postId);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deletePost(PostBlogs postBlogs) 
	{
		try {
			factory.getCurrentSession().delete(postBlogs);
		return true;	
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<PostBlogs> getAllPosts() {
		try
		{
			Query<PostBlogs> query=factory.getCurrentSession().createQuery("from PostBlogs",PostBlogs.class);
			return query.getResultList();
		}
		catch (Exception e) {
			return null;	// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

}
