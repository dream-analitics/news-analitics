<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>news-analytics</title>
</head>
<body>
  <%=new Date()%>
  <br><br>
  <div> <!-- news div -->
    <c:if test="${not empty articles}">
      <c:forEach items="${articles}" var="article">
        ${article.topic} <br>
        <h5>${article.title}</h5>
        <p>${article.text}</p>
        ${article.date}
        <br><br>
      </c:forEach>
    </c:if>
    <c:if test="${empty articles}">
      <h6>News list is empty</h6>
    </c:if>


  </div>


  <a href="/">
    <h4>Main Page</h4>
  </a>
</body>
</html>
