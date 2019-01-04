package app.Daoimpl;

import app.dao.UserDAO;
import app.dto.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public boolean addUser(User user) {
		try {	
			
	        
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setCreatedBy(user.getUsername());
			sessionFactory.getCurrentSession().persist(user);	
			return true;
			
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateUser(Integer userId) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
