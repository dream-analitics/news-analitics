<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="news" tagdir="/WEB-INF/tags/news" %>

<html>
<head>

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
  <script type="text/javascript">
    var jq = jQuery.noConflict();
  </script>


  <title>news-analytics</title>

  <style type="text/css">
    .topicelement {
      margin: 2px; padding: 1px; background: #ccc97e; display: inline; cursor: pointer;
    }
    .topicelement:hover {
      background: #cc9f51;
    }
  </style>
</head>
<body>
  <%=new Date()%>

  <a href="/">
    <h4>Main Page</h4>
  </a>

  <br><br>
  <div> <!-- news div -->
    <c:if test="${not empty root_categories}">

      <div style="margin: 5px; padding: 5px; background: #556155;">
        <c:forEach items="${root_categories}" var="category">
          <div class="topicelement">
            <div onclick="loadCategoryNews(${category.id});" style="display: inline;">
            ${category.name}
            </div>
          </div>
        </c:forEach>
      </div>

      <!-- News -->
      <div style="margin: 5px; padding: 5px; background: #556155;">
        <div id="news-holder">
          <news:news articles="${articles}" />
        </div>
      </div>


    </c:if>
    <c:if test="${empty articles}">
      <h6>News list is empty</h6>
    </c:if>


  </div>


  <a href="/">
    <h4>Main Page</h4>
  </a>

  <script type="text/javascript">

    function loadCategoryNews(categoryId) {

      var myNode = document.getElementById("news-holder");
      while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
      }
      myNode.appendChild(document.createTextNode("Loading . . ."));

      jq.ajax({
        url: "/news/srefresh",
        data: {categoryId: categoryId},
        type: 'get',
        success: function (data) {

          while (myNode.firstChild) {
            myNode.removeChild(myNode.firstChild);
          }

          var length = data.articles.length,
                  element = null;
          for (var i = 0; i < length; i++) {
            article = data.articles[i];


            var divv = jq(
                    "<div style='margin: 5px; padding: 5px; background: #b8ccb7;'>" +
                    article.topic + "<br>" +
                    "<h5>" + article.title + "</h5>" +
                    "<p>" + article.text + "</p>" +
                    new Date(article.date) +
                    "<br>" +
                    "</div>"

            )

            jq("#news-holder").append(divv);
          }
        },
        error: function (jqXHR, textStatus, errorThrown) {
          console.log('error' + errorThrown);
        }})

//      });
//        jq.get("/news/srefresh",
//                {
//                  categoryId:  categoryId
//                },
//                function(data){
//                  // data contains the result
//                  // Assign result to the sum id
//
//
//                  jq("#news-holder").innerHTML = "sdfsdf";
//
//                })
    }

  </script>
</body>
</html>
