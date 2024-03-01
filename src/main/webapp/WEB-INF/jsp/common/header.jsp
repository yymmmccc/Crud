<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 테일윈드 불러오기 -->
<!-- 노말라이즈, 라이브러리 -->
<script src="https://cdn.tailwindcss.com"></script>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" href="/resource/common.css"/>

<script src="/resource/common.js" defer='defer'></script> 
<title>TellYa!</title>
</head>
<body>
	<div class="h-20 flex container mx-auto text-4xl">
		<a class="px-3 flex items-center" href="/">
			<span>로고</span>
		</a>
		<div class="flex-grow"></div>
		<ul class="flex">
		<c:if test="${empty sessionScope.member}"> 
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/member/login">로그인</a></li>
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/member/join">회원가입</a></li>
		</c:if>
		<c:if test="${!empty sessionScope.member}">
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/member/logout">로그아웃</a></li>
		</c:if>
		<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/board/list?type=1&page=1">공지사항</a></li>
		<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/board/list?type=2&page=1">자유게시판</a></li>
		</ul>
	</div>
	<hr>