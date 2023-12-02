<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>さまざまなフォームバインド</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">さまざまなフォームバインド</h2>
		<p class="text-danger">
			<c:out value="${errorMsg}" />
		</p>
		<form:form modelAttribute="type7Form" class="mt-4">
			<div class="container mt-5">
				<ul class="list-group">
					<li class="list-group-item">生徒情報は<a href="<c:url value="/type7/student-info" />">こちら</a></li>
					<li class="list-group-item">テスト結果は<a href="<c:url value="/type7/test-info" />">こちら</a></li>
				</ul>
			</div>
			<div class="form-group text-center  mt-4">
				<!-- 戻るボタン -->
				<a href="<c:url value="/type7/clear-session"/>" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>

</body>
</html>