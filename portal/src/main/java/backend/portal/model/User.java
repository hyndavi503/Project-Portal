package backend.portal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int uid;
private String name;
private String email;
private String mobile;
private String password;
private String role;
private boolean status=false;


public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}

@JsonIgnore
@OneToMany(mappedBy="user")
private List<PostBlogs> postBlogs;




public List<PostBlogs> getPostBlogs() {
	return postBlogs;
}
public void setPostBlogs(List<PostBlogs> postBlogs) {
	this.postBlogs = postBlogs;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
