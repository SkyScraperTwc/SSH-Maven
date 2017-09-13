<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>
</head>   
<body>    
		<div id="content">
		<table align="center" border="1"  width="700" height="260">
			<caption id = "cap">用户列表</caption>
			<thead>
				<tr>
					<th width="15%">序号</th>
					<th width="25%">姓名</th>
					<th width="20%">年龄</th> 
					<th width="20%">时间</th>
					<th width="20%"></th>
				</tr>
			</thead>  

			<tbody>
				 
				<c:choose>	
					<c:when test = "${null==requestScope.userList or fn:length(requestScope.userList)==0}  ">
						<tr>
						   <td align="center" colspan="6">暂时没有数据！<td>
						</tr> 
					</c:when>  
					
					<c:otherwise>
					  <c:forEach items="${requestScope.userList }" var="user" varStatus="sta">
						<tr align='center'> 
							<td>${user.id}</td><!--序号1234567890  -->
							<td align="center"><a href=''>${user.userName }</a></td>
							<td>${user.age }</td>
							<td>${user.date}</td> 
							<td> <a href="/Spring-Struts-Hibernate/user/userAction_toEdit?userId=${user.id }">修改</a> 
									 | <a href="/Spring-Struts-Hibernate/user/userAction_delete?userId=${user.id }">删除</a></td>
						</tr>
			       </c:forEach>
				</c:otherwise>  
				  
				</c:choose>		
				
			</tbody> 
		</table>
		</div>		
</body>    
</html>            