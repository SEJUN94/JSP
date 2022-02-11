<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:set var="scope" value="pageContext" scope="page" />
<c:set var="scope" value="request" scope="request" />
<c:set var="scope" value="session" scope="session" />
<c:set var="scope" value="application" scope="application" />


<c:set var="msg" value="pageContext" scope="page" />
<c:set var="msg" value="request" scope="request" />
<c:set var="msg" value="session" scope="session" />
<c:set var="msg" value="application" scope="application" />

<c:remove var="scope" scope="request" />
<c:remove var="msg" />

<ul>
	<li>pageContext : ${pageScope.scope }</li>
	<li>request : ${requestScope.scope }</li>
	<li>session : ${sessionScope.scope }</li>
	<li>application : ${applicationScope.scope }</li>
</ul>

<ul>
	<li>pageContext : ${pageScope.msg }</li>
	<li>request : ${requestScope.msg }</li>
	<li>session : ${sessionScope.msg }</li>
	<li>application : ${applicationScope.msg }</li>
</ul>
