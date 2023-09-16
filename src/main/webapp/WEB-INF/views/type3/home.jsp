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
		<h3>顧客データ一覧</h3>

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
						<td><a href="#" class="btn btn-primary mr-2">詳細</a> <a
							href="#" class="btn btn-warning">編集</a></td>
					</tr>
				</c:forEach>
			</tbody>
	</div>
</body>
</html>