package backend.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Admin 

{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminid;
	private String adminname;
	private String adminemail;
	private String adminpassword;
	private String adminmobile;
	private String role="admin";
	private  boolean status=true;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public String getAdminmobile() {
		return adminmobile;
	}
	public void setAdminmobile(String adminmobile) {
		this.adminmobile = adminmobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", adminemail=" + adminemail
				+ ", adminpassword=" + adminpassword + ", adminmobile=" + adminmobile + ", role=" + role + ", status="
				+ status + "]";
	}
	
	
	

}
