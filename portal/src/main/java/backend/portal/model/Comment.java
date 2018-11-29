package backend.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Comment 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentid;
	@Lob
	private String comment;
	
	
	
	@JsonIgnore
	@ManyToOne
	private PostBlogs postBlogs;
	@ManyToOne
	private User user;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public PostBlogs getPostBlogs() {
		return postBlogs;
	}
	public void setPostBlogs(PostBlogs postBlogs) {
		this.postBlogs = postBlogs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
