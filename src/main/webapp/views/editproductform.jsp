<%@page import="org.springframework.http.HttpStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Products</title>
<style>
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
        <a class="nav-link" href="../home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../add">Add</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../select">Search</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="../fetchall">Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../contact">Contact</a>
      </li>
    </ul>
  </div>
</nav>

<section class="container mt-3">
<h1>Update Product</h1>
<form action="/addproduct" method="post">
<div class="row">
    <div class="col input-group">
      <span class="input-group-text">Product ID</span>
      <input type="text" class="form-control" name="p_id" placeholder="Enter Product Id" value="${product.getP_id()}" required/>
    </div>
    <div class="col input-group">
      <span class="input-group-text">Product Name</span>
      <input type="text" class="form-control" name="p_name" placeholder="Enter Product Name" value="${product.getP_name()}" required/>
    </div>
</div><br>
<div class="row">
    <div class="col input-group">
    <span class="input-group-text">Category</span>
    <select class="form-select" name="p_type"  required>
      <option value="none"></option>
      <option value="menclothing">Men Clothing</option>
      <option value="womenclothing">Women Clothing</option>
      <option value="electronics">Electronics</option>
    </select>
    </div>
    <div class="col input-group">
    <span class="input-group-text">Price &#8377;</span>
      <input type="text" class="form-control" name="p_price" placeholder="Enter Price" value="${product.getP_price()}" required/>
    </div>
</div><br>
<textarea name="p_description" class="form-control" rows="8" cols="30" placeholder="Description">"${product.getP_description()}"</textarea><br>
<input type="submit" value="Submit" class="btn btn-success">
</form>
</section>
</body>
</html>