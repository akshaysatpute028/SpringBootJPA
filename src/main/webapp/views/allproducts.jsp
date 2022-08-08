<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body{
padding: 10px;
font-family: monospace;
font-size: xx-large
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="./home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./add">Add</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./select">Search</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="./fetchall">Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./contact">Contact</a>
      </li>
    </ul>
  </div>
</nav>

<section class="container mt-3">
${status}
<h1>All Products <button type="button" onclick=" location.href='./add' " class="btn btn-outline-success">Add Product +</button></h1>
<table class="table table-striped table-bordered table-sm table-hover">
<thead class="table-info">
<tr>
<th>Id</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Description</th>
<th colspan="2">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="product" items="${productlist}">
	<tr> 
	  <td>${product.p_id}</td>
	  <td>${product.p_name}</td>
	  <td>${product.p_type}</td>
	  <td>${product.p_price}</td>
	  <td>${product.p_description}</td>
	  <td><button onclick=" location.href='./edit/${product.p_id}' " type="button" class="btn btn-outline-primary">Edit</button></td>
	  <td><button onclick=" location.href='./delete/${product.p_id}' " type="button" class="btn btn-outline-danger">Delete</button></td>
	</tr>
</c:forEach>
</tbody>
</table>
</section>

</body>
</html>