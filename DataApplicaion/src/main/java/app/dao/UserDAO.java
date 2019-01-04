package app.dao;



import java.util.List;

import app.dto.User;

public interface UserDAO {
	
	public boolean addUser(User user);
	User getByUserName(String username);
    public List<User> getAllUsers();
    public boolean deleteUser(Integer userId);
    public boolean updateUser(Integer userId);
    

}
