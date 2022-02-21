<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title default="kim's system" /></title>

<decorator:head />
</head>
<body>
<h1>header</h1>
<hr/>

<decorator:body />

<hr/>
<h1>footer</h1>

</body>
</html>