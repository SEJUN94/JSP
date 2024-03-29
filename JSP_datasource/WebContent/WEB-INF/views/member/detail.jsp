<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>


<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

<!-- Font Awesome Icons -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">

</head>
<body>
	
  <!-- Content Wrapper. Contains page content -->
  <div >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상세페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">회원관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
    <!-- Main content -->
    <section class="content register-page">       
		<div class="register-box">         
	    	<form role="form" class="form-horizontal"  method="post">
	    		<div class="register-card-header" >
	    			<h1 class="text-center">회원 상세보기</h1>
	    		</div>
	        	<div class="register-card-body" >
	            	<div class="row"  style="height:200px;">
						<div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">							
							<div id="pictureView" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>														
						</div>
					</div>
					<br />
	                <div class="form-group row" >
	                  <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
	
	                  <div class="col-sm-9">
	                    <input name="id" type="text" class="form-control" id="inputEmail3"  value="${member.id }" readonly>
	                  </div>
	                </div>	               
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이  름</label>
	
	                  <div class="col-sm-9">
	                    <input name="pwd" type="text" class="form-control" id="inputPassword3" value="${member.name }" readonly>
	                  </div>
	                </div>
	                 <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
	
	                  <div class="col-sm-9">
	                    <input name="email" type="email" class="form-control" id="inputPassword3" value="${member.email }" readonly>
	                  </div>
	                </div>
	                 <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">전화번호</label>
	                  <div class="col-sm-9">   
	                  	<input name="phone" type="text" class="form-control" id="inputPassword3" value="${member.phone }" readonly>	                
	                  </div>                  
	                </div>               
	              </div>  
		          <div class="card-footer" style="padding:5px 0;" >
		          		<div class="row">
		          	<%-- 	<c:if test="${loginUser.id eq member.id }"> --%>
			          		<div class="col-sm-3 text-center">
			          			<button type="button" onclick="location.href='modifyForm.do?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
			          		</div>
		          		
			          		<div class="col-sm-3 text-center">
<%-- 			          			<button type="button" onclick="location.href='remove.do?id=${member.id}';" id="deleteBtn" class="btn btn-danger" >삭 제</button> --%>
			          			<button type="button" onclick="deleteMember('${member.id}')" id="deleteBtn" class="btn btn-danger" >삭 제</button>
			          		</div>
		          			
			          		<div class="col-sm-3 text-center">
			          			<c:if test="${member.enabled ne 0 }">
			          			<button type="button" onclick="location.href='stop.do?id=${member.id}';" 
			          			id="stopBtn" class="btn btn-info" >비활성</button>
			          			</c:if>
			          			<c:if test="${member.enabled eq 0 }">
			          			<button type="button" onclick="location.href='active.do?id=${member.id}';" 
			          			id="activeBtn" class="btn btn-info" >활&nbsp;&nbsp;성</button>
			          			</c:if>
			          		</div>
		          		<%-- </c:if> --%>
		          	
			          		<div class="col-sm-3 text-center">
			            		<button type="button" id="listBtn" onclick="window.close();" class="btn btn-primary pull-right">닫 기</button>
			            	</div>
		          	    </div>  	
		          </div>
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
<script>
	function deleteMember(mem_id) {
		var aa = confirm("정말 삭제 하시겠습니까?")
		
		if (aa) {
			location.href='delete?id='+mem_id
		}
	}
	

</script>
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>
</html>