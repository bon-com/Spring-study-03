<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>顧客情報確認</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報確認</h2>
		<div class="container mt-5">
			<table class="table table-bordered">
				<tr>
					<th class="col-3">名前</th>
					<td class="col-7">${createUserForm.name}</td>
				</tr>
				<tr>
					<th class="col-3">メールアドレス</th>
					<td class="col-7">${createUserForm.email}</td>
				</tr>
				<tr>
					<th class="col-3">生年月日</th>
					<td class="col-7">
						<fmt:formatDate value="${createUserForm.birthday}" pattern="yyyy年MM月dd日" />
					</td>
				</tr>
				<tr>
					<th class="col-3">出身</th>
					<td class="col-7">${prefName}</td>
				</tr>
			</table>
		</div>
		<div class="form-group text-center">
			<!-- 戻るボタン -->
			<a href="${contextPath}type9/user/create-user" class="btn btn-danger mr-4 px-5">戻る</a>
			<a href="${contextPath}type9/user/register-user" class="btn btn-primary px-5">登録</a>
		</div>
	</div>
</body>
</html>