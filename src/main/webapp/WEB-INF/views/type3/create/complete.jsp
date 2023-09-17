<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>顧客情報登録完了</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報登録完了</h2>
		<form class="mt-4" method="post">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">名前</th>
						<td class="col-7">${createForm.name}</td>
					</tr>
					<tr>
						<th class="col-3">メールアドレス</th>
						<td class="col-7">${createForm.email}</td>
					</tr>
					<tr>
						<th class="col-3">生年月日</th>
						<td class="col-7"><fmt:formatDate
								value="${createForm.birthDay}" pattern="yyyy年MM月dd日" /></td>
					</tr>
					<tr>
						<th class="col-3">好きな数字</th>
						<td class="col-7">${createForm.favoriteNum}</td>
					</tr>
					<tr>
						<th class="col-3">出身</th>
						<td class="col-7">${prefName}</td>
					</tr>
				</table>
			</div>
			<div class="d-flex justify-content-center mt-2">
				<a href="${contextPath}type3/home">顧客一覧画面へ戻る</a>
			</div>
		</form>
	</div>
</body>
</html>