<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>顧客情報一覧画面</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報一覧画面</h2>
		<a href="${contextPath}" class="btn btn-danger mb-4 mr-4">戻る</a> <a
			href="${contextPath}type3/customer/create" class="mb-4 btn btn-success">新規作成</a>
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>メールアドレス</th>
					<th>アクション</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td><c:out value="${customer.id}" /></td>
						<td><c:out value="${customer.name}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><a href="${contextPath}type3/customer/${customer.id}"
							class="btn btn-primary mr-2">詳細</a> 
							<a href="${contextPath}type3/customer/${customer.id}/edit"
							class="btn btn-warning mr-2">編集</a>
							<a href="${contextPath}type3/customer/${customer.id}/delete"
							class="btn btn-danger">削除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			</div>
</body>
</html>