<%@page import="java.util.List"%>
<%@page import="com.a2m.dao.CategoryDAO"%>
<%@page import="com.a2m.dto.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Danh mục</h1>
	<a href="/Base-mvc/category/create">Create</a>
	
	<% 
		CategoryDAO dao = new CategoryDAO();
       	List<Category> lisCategories = dao.getAll();
	%>
	<table>
		<thead>
			<tr>
				<th>Category Id</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
	<% for(int i = 0; i < lisCategories.size(); i++){ 
		Category u = lisCategories.get(i);
	%>
	
			<tr>
				<td><%=u.getCategoryId() %></td>
				<td><%=u.getName() %></td>
				<td>
					<a href="/Base-mvc/category/delete/<%=u.getCategoryId() %>">Delete</a>
					<a href="/Base-mvc/category/edit/<%=u.getCategoryId() %>">Edit</a>
				</td>
				
			</tr>
		
		
		<%-- <h3>Fullname: <%=u.getFullname() %></h3> --%>
	
	<%} %>
	
	</tbody>
	</table>
</body>
</html>