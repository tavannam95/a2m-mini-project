<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Thêm danh mục</h1>
	<form action="/Base-mvc/category/create" method="post">
		<label for="">Mã danh mục</label>
        <input type="text" name="categoryId"> <br>
		<label for="">Tên danh mục</label>
        <input type="text" name="name"> <br>
        <button type="submit">Create</button>
	</form>
</body>
</html>