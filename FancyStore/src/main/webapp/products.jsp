<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.fancystore.dao.ProductDAO,com.fancystore.model.Product" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-4">

<h2 class="text-center mb-4">Available Products</h2>

<!-- SEARCH BAR -->
<form action="SearchProductServlet" method="get" class="d-flex mb-4">
<input type="hidden" name="source" value="admin">
<input type="text" name="keyword" class="form-control me-2" placeholder="Search products...">
<button class="btn btn-primary">Search</button>
<a href="products.jsp" class="btn btn-secondary ms-2">Reset</a>
</form>

<%
List<Product> list = (List<Product>)request.getAttribute("products");

if(list == null){
    ProductDAO dao = new ProductDAO();
    list = dao.getAllProducts();
}
%>

<div class="row">

<%
for(Product p : list){
%>

<div class="col-md-3 mb-4">

<div class="card shadow">

<img src="<%=request.getContextPath()+"/"+p.getImage()%>" 
class="card-img-top"
style="height:200px; object-fit:cover;">

<div class="card-body text-center">

<h5 class="card-title"><%=p.getName()%></h5>

<p class="card-text">₹ <%=p.getPrice()%></p>

<p class="text-muted"><%=p.getCategory()%></p>

<a href="EditProductServlet?id=<%=p.getId()%>" 
class="btn btn-warning btn-sm">
Edit
</a>

<a href="DeleteProductServlet?id=<%=p.getId()%>"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this product?');">
Delete
</a>

</div>
</div>
</div>

<%
}
%>

</div>
</div>

</body>
</html>