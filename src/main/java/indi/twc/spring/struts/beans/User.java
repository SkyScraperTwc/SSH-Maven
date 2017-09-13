package indi.twc.spring.struts.beans;

import lombok.Data;
import java.util.Date;

@Data
public class User {
	
	private Integer id;  
    
    private String userName;  
      
    private Integer age;  
    
    private Date date;
}
