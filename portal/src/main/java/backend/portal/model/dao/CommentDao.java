package backend.portal.model.dao;

import java.util.List;

import backend.portal.model.Comment;

public interface CommentDao {

	
	public boolean addComment(Comment comment);
	public List<Comment> getCommentsByPostId(int postId);
	
}
