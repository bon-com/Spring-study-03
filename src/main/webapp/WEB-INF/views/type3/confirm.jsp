<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header_common.jsp"%>
<title>顧客情報確認画面</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報確認画面</h2>
		<form class="mt-4" method="post">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">名前</th>
						<td class="col-7">${editForm.name}</td>
					</tr>
					<tr>
						<th class="col-3">メールアドレス</th>
						<td class="col-7">${editForm.email}</td>
					</tr>
					<tr>
						<th class="col-3">生年月日</th>
						<td class="col-7"><fmt:formatDate
								value="${editForm.birthDay}" pattern="yyyy年MM月dd日" /></td>
					</tr>
					<tr>
						<th class="col-3">好きな数字</th>
						<td class="col-7">${editForm.favoriteNum}</td>
					</tr>
					<tr>
						<th class="col-3">出身</th>
						<td class="col-7">${prefName}</td>
					</tr>
				</table>
			</div>
			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<c:url var="url"
					value='//type3/customer/${editForm.id}/edit-customer' />
				<a href="${url}" class="btn btn-danger">戻る</a>
				<button type="submit" name="complete" class="btn btn-primary">次へ</button>
			</div>
		</form>
	</div>
</body>
</html>