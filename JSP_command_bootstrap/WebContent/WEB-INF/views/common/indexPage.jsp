<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>메인페이지</title>

<head></head>


<body>
	
	<iframe name="ifr" src="" frameborder="0" style="width:100%;height:85vh;"></iframe>
	
	<script>
		function goPage(url,mComde){
			$('iframe[name="ifr"]').attr("src",url);
		}
	</script>
</body>
