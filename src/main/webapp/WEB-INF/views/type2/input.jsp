<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/commons/header_common.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<!-- コンテナクラスを追加 -->
		<h2 class="text-center">入力画面</h2>
		<form:form modelAttribute="type2Form" method="post" action="${pageContext.request.contextPath}/type2/create" class="mt-4">
			<!-- テキストボックス -->
			<div class="form-group">
				<label for="name">名前：</label>
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" cssClass="text-danger" />
			</div>

			<!-- 数値入力 -->
			<div class="form-group">
				<label for="age">年齢：</label>
				<form:input path="age" type="number" cssClass="form-control" />
				<form:errors path="age" cssClass="text-danger" />
			</div>


			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="<c:url value='/' />" class="btn btn-danger mr-4">戻る</a>

				<!-- 次へボタン -->
				<button type="submit" name="confirm" class="btn btn-primary">確認</button>
			</div>
		</form:form>
	</div>
</body>
</html>