package indi.twc.spring.struts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import indi.twc.spring.struts.beans.User;
import indi.twc.spring.struts.dao.UserDao;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;
	
	public boolean addUser(User user) {
		return userDao.addUser(user); 
	} 
  
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
 
	public boolean deleteUser(Integer id) {
		return userDao.delUser(id); 
	}

	public User getUser(Integer id) {
		return userDao.getUser(id); 
	} 

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}
	
}
