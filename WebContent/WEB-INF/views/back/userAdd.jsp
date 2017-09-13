<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>   
<body>     
			<form action="/Spring-Struts-Hibernate/user/userAction_add" method="post" >  
		     	 <table title="用户添加" align="center" border="1" >
		     	  <caption>用户添加</caption>
		     	 <tr>
						<td>姓名：</td>  
						<td>
							<input type="text" name="user.userName">
						</td>
				 </tr>
				 <tr>
						<td>年龄：  </td> 
						<td>
							<input type="text" name="user.age"> 
						</td> 
				  </tr>
				  <tr>
						<td colspan="2">
						  <input type="submit" value="submit" >     
						</td>
				   </tr>
				 </table> 
			</form> 
</body>    
</html>               