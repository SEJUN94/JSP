<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert('${member.name}님을 삭제했습니다.');
	window.close();
	window.opener.parent.loaction.reload(true);
</script>