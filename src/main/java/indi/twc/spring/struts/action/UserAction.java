package indi.twc.spring.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import indi.twc.spring.struts.beans.User;
import indi.twc.spring.struts.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Data
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{ 
	
	@Autowired
	private UserService userService;
    
	private User user;
	
	private Integer userId;
	
	private List<User> userList;
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add(){
		System.out.println(user);
		user.setDate(new Date()); 
		boolean flag = userService.addUser(user); 
		if(flag){
			return "redirectList"; 
		}else{
			return null;
		}
	}  
	
	public String list(){ 
	    userList = userService.getAllUser(); 
		return "list";
	} 
	  
	public String delete(){
		boolean flag = userService.deleteUser(userId); 
		if(flag){  
			return "redirectList";    
		}else{
			return null;
		}     
	} 
	
	public String toEdit(){
	    user = userService.getUser(userId);
		return "toEdit"; 
	} 
	 
	public String edit(){
		user.setDate(new Date());    
		System.out.println(user);
		boolean flag = userService.updateUser(user); 
		if(flag){  
			return "redirectList"; 
		}else{ 
			return null;
		}    
	}
}  
     