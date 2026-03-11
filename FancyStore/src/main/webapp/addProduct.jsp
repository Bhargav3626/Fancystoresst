<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

<h2>Add Product</h2>

<form action="AddProductServlet" method="post" enctype="multipart/form-data">

<div class="mb-3">

<label>Product Name</label>

<input type="text" name="name" class="form-control">

</div>


<div class="mb-3">

<label>Price</label>

<input type="text" name="price" class="form-control">

</div>


<div class="mb-3">

<label>Category</label>

<input type="text" name="category" class="form-control">

</div>


<div class="mb-3">

<label>Upload Image</label>

<input type="file" name="image" class="form-control">

</div>


<button class="btn btn-success">
Add Product
</button>

</form>

</div>

</body>
</html>