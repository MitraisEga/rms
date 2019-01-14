<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<header class="mdl-layout__header mdl-layout__header">
        <div class="mdl-layout__header-row">
          <!-- Title -->
          <span class="mdl-layout-title">RMS</span>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <!-- Navigation -->
          <nav class="mdl-navigation">
          <% if(request.getSession(false) !=null && request.getSession(false).getAttribute("User") != null) { %>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%> ">Home</a>
            <a class="mdl-navigation__link" href="<%=request.getContextPath()%>/users/list">Users</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="<%=request.getContextPath()%>/logout">Logout</a>
          <% } else { %>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%>">Home</a>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%>/login">Login</a>
          <% } %>
          </nav>
        </div>
      </header>
      <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">RMS</span>
        
        <nav class="mdl-navigation">
          <% if(request.getSession(false) !=null && request.getSession(false).getAttribute("User") != null) { %>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%>">Home</a>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%>/users/list">Users</a>
          <a class="mdl-navigation__link" href="">Link</a>
          <a class="mdl-navigation__link" href="">Link</a>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%>/logout">Logout</a>
          <% } else { %>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%> ">Home</a>
          <a class="mdl-navigation__link" href="<%=request.getContextPath()%>/login">Login</a>
          <% } %>
        </nav>
      </div>