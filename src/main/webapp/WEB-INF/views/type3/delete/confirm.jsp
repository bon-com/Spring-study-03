<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>顧客情報削除確認</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報削除確認</h2>
		<div class="container mt-5">
		<h4 class="text-center mb-2">以下の顧客情報を削除してもよろしいですか？</h4>
			<table class="table table-bordered mt-4">
				<tr>
					<th class="col-3">名前</th>
					<td class="col-7">${customer.name}</td>
				</tr>
				<tr>
					<th class="col-3">メールアドレス</th>
					<td class="col-7">${customer.email}</td>
				</tr>
				<tr>
					<th class="col-3">生年月日</th>
					<td class="col-7"><fmt:formatDate
							value="${customer.birthDay}" pattern="yyyy年MM月dd日" /></td>
				</tr>
				<tr>
					<th class="col-3">好きな数字</th>
					<td class="col-7">${customer.favoriteNum}</td>
				</tr>
				<tr>
					<th class="col-3">出身</th>
					<td class="col-7">${prefName}</td>
				</tr>
			</table>
		</div>
			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="${contextPath}type3/home" class="btn btn-danger mr-4 px-5">いいえ</a>
				<a href="${contextPath}type3/customer/${customer.id}/delete-done" class="btn btn-primary px-5">はい</a>
			</div>
	</div>
</body>
</html>