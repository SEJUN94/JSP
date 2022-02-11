<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 주소api -->
<script type="text/javascript">
	function findZip() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				var addr = ''; // 주소 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				// 	       document.getElementById('zip').value = data.zonecode;
				document.getElementById("address").value = addr;
			}
		}).open();
	}
</script>
</head>
<body>

	<h1>개인정보수정</h1>
	<hr />
	<form action="update" method="post">
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="hidden" class="" id="id" name="id"
					value="${member.id}">${member.id}</td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td><input type="text" class="" id="pwd" name="pwd" value=""></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" class="" id="name" name="name"
					value="${member.name}"></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><input type="text" class="" id="phone" name="phone"
					value="${member.phone }"></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="text" class="" id="email" name="email"
					value="${member.email }"></td>
			</tr>
			<!-- 		<li>우편번호 : <input type="text" class="" id="zip" name="zip" value=""></li> -->
			<tr>
				<td>주소 :</td>
				<td><input type="text" class="" id="address" name="address"
					value="${member.address }"></td>
				<td><button type="button" onclick="findZip();">주소검색</button></td>
			</tr>
		</table>
		<input id="sendBtn" type="submit" value="정보수정">
	</form>
	<br />
	<button onclick="list_go();">돌아가기</button>
	<script>
		function list_go() {
			location.href = "list";
		}
	</script>
</body>
</html>