package backend.portal.model.dao;

import java.util.List;

import backend.portal.model.User;

public interface UserDao {

	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
public User getUserByEmail(String email);
public User login(String email,String password);
public List<User> getTrainers();
public User getUserById(int uid);
}
