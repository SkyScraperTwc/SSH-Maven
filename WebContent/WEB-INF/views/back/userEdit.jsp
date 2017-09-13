<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>   
<body>     
			<form action="/Spring-Struts-Hibernate/user/userAction_edit" method="post">  
			
		     	 <input type="hidden" name="user.id" value="${user.id }"/>
		     	 
		     	 <table title="用户修改" align="center" border="1">
		     	 
		     	 <caption>用户修改</caption>
		     	 <tr> 
						<td>姓名：</td>  
						<td>
							<input type="text" name="user.userName" value="${user.userName }"/>
						</td>
				 </tr>   
				 <tr> 
						<td>年龄：  </td>  
						<td>
							<input type="text" name="user.age" value="${user.age }"/> 
						</td> 
				  </tr>
				  <tr>
						<td colspan="2">
						  <input type="submit" value="submit"/>     
						</td>
				   </tr>
				 </table> 
			</form> 
</body>    
</html>               