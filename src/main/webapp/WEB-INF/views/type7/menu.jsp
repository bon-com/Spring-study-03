<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>さまざまなフォームバインド</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">さまざまなフォームバインド</h2>
		<form:form modelAttribute="type6Form" class="mt-4">
			<div class="container mt-5">
				<ul class="list-group">
					<li class="list-group-item">生徒情報は<a href="${contextPath}type7/student-info">こちら</a></li>
					<li class="list-group-item">テスト結果は<a href="${contextPath}type7/test-info">こちら</a></li>
				</ul>
			</div>
			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="${contextPath}type7/clear-session" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>

</body>
</html>