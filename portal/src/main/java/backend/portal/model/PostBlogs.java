package backend.portal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class PostBlogs 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
public int postId;
public String postTitle;
@Lob
public String postDescription;

@ManyToOne
private User user;

@JsonIgnore
@OneToMany
private List<Comment> comments;

public int getPostId() {
	return postId;
}

public void setPostId(int postId) {
	this.postId = postId;
}

public String getPostTitle() {
	return postTitle;
}

public void setPostTitle(String postTitle) {
	this.postTitle = postTitle;
}

public String getPostDescription() {
	return postDescription;
}

public void setPostDescription(String postDescription) {
	this.postDescription = postDescription;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}




public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

@Override
public String toString() {
	return "PostBlogs [postId=" + postId + ", postTitle=" + postTitle + ", postDescription=" + postDescription
			+ ", user=" + user + "]";
}




}
