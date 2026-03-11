<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("admin") == null){
        response.sendRedirect("adminLogin.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">

    <span class="navbar-brand">Fancy Store Admin Dashboard</span>

    <div>
        <a href="products.jsp" class="btn btn-success btn-sm">View Products</a>
        <a href="addProduct.jsp" class="btn btn-primary btn-sm">Add Product</a>
        <a href="LogoutServlet" class="btn btn-danger btn-sm">Logout</a>
    </div>

  </div>
</nav>

<!-- CONTENT -->
<div class="container mt-5">

<h3>Welcome Admin</h3>
<hr>

<div class="row">

<!-- Add Product Card -->
<div class="col-md-4">
<div class="card shadow p-3">
<h5>Add Product</h5>
<p>Add new items to the store</p>
<a href="addProduct.jsp" class="btn btn-primary">Add Product</a>
</div>
</div>

<!-- View Products Card -->
<div class="col-md-4">
<div class="card shadow p-3">
<h5>View Products</h5>
<p>Manage all store products</p>
<a href="products.jsp" class="btn btn-success">View Products</a>
</div>
</div>

<!-- Logout Card -->
<div class="col-md-4">
<div class="card shadow p-3">
<h5>Logout</h5>
<p>Securely exit admin panel</p>
<a href="LogoutServlet" class="btn btn-danger">Logout</a>
</div>
</div>

</div>

</div>

</body>
</html>