<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.fancystore.dao.ProductDAO,com.fancystore.model.Product" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Sree Sahasraa Trends</title>

<!-- Bootstrap CDN -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background:#f8f9fa;
}

.store-title{
font-weight:bold;
font-size:22px;
}

.footer{
background:#222;
color:white;
padding:20px;
margin-top:40px;
}

.contact-section{
background:white;
padding:30px;
margin-top:40px;
border-radius:10px;
box-shadow:0 0 10px rgba(0,0,0,0.1);
}

</style>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-dark bg-dark">
<div class="container">

<span class="navbar-brand store-title">
Sree Sahasraa Trends
</span>

</div>
</nav>

<div class="container mt-4">

<h2 class="text-center mb-4">Our Products</h2>

<!-- SEARCH BAR -->

<form action="SearchProductServlet" method="get" class="d-flex mb-4">

<input type="hidden" name="source" value="customer">

<input type="text"
name="keyword"
class="form-control me-2"
placeholder="Search products...">

<button class="btn btn-primary">
Search
</button>

<a href="index.jsp" class="btn btn-secondary ms-2">
Reset
</a>

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

<h5 class="card-title">
<%=p.getName()%>
</h5>

<p class="card-text">
₹ <%=p.getPrice()%>
</p>

<p class="text-muted">
<%=p.getCategory()%>
</p>

</div>

</div>

</div>

<%
}
%>

</div>

</div>

<!-- CONTACT SECTION -->

<div class="container">

<div class="contact-section text-center">

<h4>Contact Us</h4>

<p>
📍 Location: Your Village, Andhra Pradesh
</p>

<p>
📞 Phone: +91 XXXXX XXXXX
</p>

<p>
📧 Email: sreeshahasraatrends@gmail.com
</p>

<p>
Follow us on:
</p>

<p>
Instagram | Facebook | WhatsApp
</p>

</div>

</div>

<!-- FOOTER -->

<div class="footer text-center">

<p>
© 2026 Sree Sahasraa Trends. All Rights Reserved.
</p>

</div>

</body>
</html>
