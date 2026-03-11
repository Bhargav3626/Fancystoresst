<%@ page import="com.fancystore.model.Product" %>

<%
Product p = (Product) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Product</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

<h2 class="text-center mb-4">Edit Product</h2>

<form action="UpdateProductServlet" method="post" class="col-md-6 mx-auto">

<input type="hidden" name="id" value="<%=p.getId()%>">

<div class="mb-3">
<label class="form-label">Product Name</label>
<input type="text" name="name" class="form-control" value="<%=p.getName()%>">
</div>

<div class="mb-3">
<label class="form-label">Price</label>
<input type="text" name="price" class="form-control" value="<%=p.getPrice()%>">
</div>

<div class="mb-3">
<label class="form-label">Category</label>
<input type="text" name="category" class="form-control" value="<%=p.getCategory()%>">
</div>

<div class="mb-3">
<label class="form-label">Image URL</label>
<input type="text" name="image" class="form-control" value="<%=p.getImage()%>">
</div>

<button type="submit" class="btn btn-success">Update Product</button>

</form>

</div>

</body>
</html>