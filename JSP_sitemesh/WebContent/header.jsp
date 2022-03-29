<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
	
<style>
	header{background:white;}
</style>
	<header>
	<div class="inner">

		<a href="/" class="logo"> <img src="<%=request.getContextPath()%>/resources/images/Rundreing12.png"
			alt="Rundreing12" />
		</a>

		<div class="sub-menu">
			<ul class="menu">
				<li><a href="/signin">Sign In</a></li>
				<li><a href="javascript:void(0)">Sign Up</a></li>
			</ul>
			<div class="search">
          		<input type="text" />
          		<span class="material-icons">search</span>
        	</div>
		</div>
	
		<ul class="main-menu">
			<li class="item"><div class="item__name">회사 소개</div></li>
			<li class="item"><div class="item__name">이용 안내</div></li>
			<li class="item"><div class="item__name">세탁 주문</div></li>
			<li class="item"><div class="item__name">고객 센터</div></li>
		</ul>
	</div>

	<!--BADGES-->
	<div class="badges">
		<div class="badge">
			<img src="" alt="Badge" />
		</div>
		<div class="badge">
			<img src="." alt="Badge" />
		</div>
	</div>
	</header>
