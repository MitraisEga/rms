<%@ page import="com.mitrais.rms.model.User"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix = "rms" uri = "/WEB-INF/tags/link.tld"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>RMS</title>
  <meta name="description" content="Index">
  <meta name="author" content="Mitrais">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
  <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  <rms:link type="stylesheet" href="css/styles.css?v=1.0"/>

  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
  <![endif]-->
</head>

<body>
    <div class="demo-layout-transparent mdl-layout mdl-js-layout">
      <jsp:include page="shared/_menu.jsp"></jsp:include>
      <main class="mdl-layout__content">
      <h4>RMS</h4>
      <% if(request.getSession(false) !=null && request.getSession(false).getAttribute("User") != null) {
      		User u = (User)request.getSession(false).getAttribute("User");
      		log(u.getUserName().toString());
		%>
  		<p>Hi <%= u.getUserName() %>, Welcome to RMS!</p>
 	  <% } else { %>
 	  <p>Welcome to RMS, Please <a class="mdl-navigation__link" href="login"><strong>Login</strong></a>!</p> 
 	  <% } %>
      </main>
    </div>
  <script src="js/scripts.js"></script>
</body>
</html>
