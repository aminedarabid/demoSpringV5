<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Lourd</title>
</head>
<body>

    <h1>TEST</h1>
	<a href="form.html">formulaire</a>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Theme</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${formationList}" var="form">
	  <tr>
	      <td>${form.id}</td>
	      <td>${form.theme}</td>
	      <td><a href="delete.html?id=${form.id}"><img src="images/supp.png" style="width:20px"></a></td>
	  </tr>
    </c:forEach>
  </tbody>
</table>
    
</body>
</html>
