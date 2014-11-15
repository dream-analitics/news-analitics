<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>news-analytics</title>
</head>
<body>
	<%=new Date()%>

	<h1>${message}</h1>

	<a href="/news">
		<h4>Read latest <b>hot</b> news</h4>
	</a>
</body>
</html>