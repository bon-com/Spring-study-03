<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>DBエラー</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">DBエラーが発生しました</h2>
		<div class="container mt-5">
			<div class="alert alert-danger" role="alert">
				エラー内容: データベースに問題が発生しました。管理者に問い合わせてください。
			</div>
		</div>
		<div class="d-flex justify-content-center mt-2">
			<a href="${contextPath}type3/home">顧客一覧画面へ戻る</a>
		</div>
	</div>
</body>
</html>
