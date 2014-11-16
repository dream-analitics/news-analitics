<%@ tag import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute required="true" name="articles" type="java.util.List<org.neigbors.analitics.dto.ArticleDto>" %>

<c:forEach items="${articles}" var="article">
    <div style="margin: 5px; padding: 5px; background: #b8ccb7;">
            ${article.topic} <br>
        <h5>${article.title}</h5>
        <p>${article.text}</p>
            ${article.date}
        <br>
    </div>
</c:forEach>
