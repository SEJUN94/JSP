<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>

<%
	int dan,gop;

	for(dan=2;dan<10;dan++){ %>
	
	<%out.println(dan+"단<br/>"); %>
	
	<%for(gop=1;gop<10;gop++){  %>
	
	<%out.println(dan+"*"+gop+"="+dan*gop+"<br/>"); %>
	<%
		}
	  %>
		<% out.println("<br/>");%>
	<% 	
	}
%>

</body>
</html>

  
