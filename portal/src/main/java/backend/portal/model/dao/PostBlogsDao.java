package backend.portal.model.dao;

import java.util.List;

import backend.portal.model.PostBlogs;

public interface PostBlogsDao 
{

	public boolean addPost(PostBlogs postBlogs);
	public boolean deletePost(PostBlogs postBlogs);
	public PostBlogs getPostByPostId(int postId);
	public List<PostBlogs> getAllPosts();
}
