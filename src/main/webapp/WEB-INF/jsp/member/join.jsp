<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jsp" %>	

<section class="mt-10"> <!-- 마진-top 10 -->
	<div>
		<div>
			<form action="/member/doJoin" method="POST">
				<br>
				아이디 : <input name="loginId" type="text" placeholder="아이디를 입력해주세요."/>
				<br>
				비밀번호 : <input name="loginPw" type="text" placeholder="비밀번호를 입력해주세요."/>
				<br>
				이름 : <input name="name" type="text" placeholder="이름을 입력해주세요."/>
				<br>
				닉네임 : <input name="nickname" type="text" placeholder="닉네임을 입력해주세요."/>
				<br>
				전화번호 : <input name="phoneNum" type="text" placeholder="전화번호를 입력해주세요."/>
				<br>
				이메일 : <input name="email" type="text" placeholder="이메일을 입력해주세요."/>
				<br>
				주소 : <input name="address" type="text" placeholder="주소를 입력해주세요."/>
				<br>
				<button>회원가입</button>
			</form>
		</div>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>