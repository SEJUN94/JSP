<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>


<header id="header">
        <nav class="navbar navbar-expand-md navbar-dark">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/user/home/main.do"><img class="logo" src="<%=request.getContextPath()%>/resources/images/Netflix_logo.svg" alt=""></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/home/main.do">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/board/board.do">Review</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/myPage/wishList.do">Wish List</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/myPage/viewRecord.do">View Record</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/myPage/DownPym.do">PayMent List</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/notice/notice.do">Notice</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user/qna/qna.do">QnA</a></li>
                </ul>
                </div>