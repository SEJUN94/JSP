<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	
	location.href='detail.do?id=${notice.nno}';

	if(confirm('공지사항이 수정되었습니다.\n현재 화면을 닫고 새로고침 하시겠습니까?')){
		window.opener.parent.loaction.reload(true);
		window.close();
		location.href="redirect:notice/detail.do?from=modify&nno="+${notice.nno};
	}
</script>