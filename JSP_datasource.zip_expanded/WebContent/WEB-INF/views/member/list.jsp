<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style>
	tr.data{ cursor:pointer;}
</style>
</head>
<body>
<h1>회원리스트</h1>
<hr/>
<button type="button">회원등록</button> 
&nbsp;&nbsp;&nbsp;&nbsp;
<select name="searchType" >
	<option value="">검색구분</option>
	<option value="i">아이디</option>
	<option value="n">이름</option>
	<option value="e">이메일</option>
</select>
<input type="text" name="keyword" /><button>검색</button>
<p></p>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>패스워드</th>
		<th>주소</th>
		<th>email</th>
		<th>전화번호</th>
	</tr>

<%-- <% 
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList"); 
	for (MemberVO member : memberList){
	pageContext.setAttribute("member", member);
%> --%>
<c:if test="${not empty memberList }"><c:forEach items="${memberList }" var="member">
	<tr class="data" onclick="detail_go('${member.id}');">
		<%-- <td><%=member.getId() %></td> --%>
		<td>${member.id }</td>
		<td>${member.name }</td>
		<td>${member.pwd }</td>
		<td>${member.address }</td>
		<td>${member.email }</td>
		<td>${member.phone }</td>
	</tr>
</c:forEach></c:if>
<c:if test="${empty memberList }">
	<tr >
		<td colspan="6" style="text-align:center;">해당 내용이 없습니다.</td>
	</tr>
</c:if>
<%-- <%			
	} 
%> --%>
	

</table>

<script>
	function detail_go(member_id){
		//alert(member_id);
		window.open('detail?id='+member_id,'800','700','');
	}
</script>
</body>
</html>






