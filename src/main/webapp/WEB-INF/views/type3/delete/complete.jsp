<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>顧客情報削除完了</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報削除完了</h2>
		<div class="container mt-5">
			<h4 class="text-center mb-4">顧客情報を削除しました。</h4>
		</div>
		<div class="d-flex justify-content-center mt-4">
			<a href="${contextPath}type3/home">顧客一覧画面へ戻る</a>
		</div>
	</div>
</body>
</html>