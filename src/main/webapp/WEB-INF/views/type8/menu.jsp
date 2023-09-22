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
		<div class="container mt-5">
			<ul class="list-group">
				<li class="list-group-item">500エラーを出すには<a href="${contextPath}type8/error-type1">こちら</a></li>
				<li class="list-group-item">404エラーを出すには<a href="${contextPath}type8/error-type2">こちら</a></li>
				<li class="list-group-item">IOException例外を出すには<a href="${contextPath}type8/error-type4">こちら</a></li>
				<li class="list-group-item">DataNotFoundException例外を出すには<a href="${contextPath}type8/error-type5">こちら</a></li>
				<li class="list-group-item">FileNotFoundException例外を出すには<a href="${contextPath}type8/error-type6">こちら</a></li>
				<li class="list-group-item">その他デフォルトエラーを出すには<a href="${contextPath}type8/error-type3">こちら</a></li>
			</ul>
		</div>
		<div class="form-group text-center">
			<!-- 戻るボタン -->
			<a href="${contextPath}type7/clear-session" class="btn btn-danger mr-4 px-5">戻る</a>
			<button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
		</div>
	</div>

</body>
</html>