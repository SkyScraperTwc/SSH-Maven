package indi.twc.spring.struts.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import indi.twc.spring.struts.beans.User;
import indi.twc.spring.struts.utils.HibernateUtils;

@Repository
public class UserDao{
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	public boolean addUser(User user) { 
		return hibernateUtils.save(user);
	}    
	
	public List<User> getAllUser() { 
		String hql = "from User";
		return hibernateUtils.queryList(hql, null);
	}

	public boolean delUser(Integer id){
		User user = new User();
		user.setId(id); 
		return hibernateUtils.delete(user);
	}

	public User getUser(Integer id) {
		String hql = "select user from User user where user.id =?";
		Object[] param = new Object[]{id};
		return (User) hibernateUtils.queryOne(hql, param);
	}
 
	public boolean updateUser(User user) {
		return false;
	}

}
