package backend.portal.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.portal.model.Comment;
import backend.portal.model.dao.CommentDao;


@Component
@Transactional
public class CommentDaoImpl implements CommentDao
{

	@Autowired
	private SessionFactory factory;
	@Override
	public boolean addComment(Comment comment) {
		try {
			factory.getCurrentSession().save(comment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public List<Comment> getCommentsByPostId(int postId) {
		try {
			Query<Comment> query=factory.getCurrentSession().createQuery("from Comment where PostBlogs_postId=:postId",Comment.class);
			query.setParameter("postId",postId);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
