<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>システムエラー</title>
</head>
<body>
	<%@ page isErrorPage="true"%>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">システムエラー</h2>
		<div class="container mt-5">
			<div class="alert alert-danger" role="alert">
				エラー内容: 申し訳ございませんが、システムのエラーが発生しました。<br /> 再度トップ画面から操作してください。
			</div>
			<table class="table table-bordered">
				<tr>
					<th class="col-3">ステータスコード</th>
					<td class="col-7"><%=response.getStatus()%></td>
				</tr>
				<tr>
					<th class="col-3">例外オブジェクト</th>
					<td class="col-7"><%=exception%></td>
				</tr>
				<tr>
					<th class="col-3">例外メッセージ</th>
					<td class="col-7"><%=exception.getMessage()%></td>
				</tr>
				<tr>
					<th class="col-3">例外の原因</th>
					<td class="col-7"><%=exception.getCause()%></td>
				</tr>
			</table>
		</div>
		<div class="d-flex justify-content-center mt-2">
			<a href="${contextPath}/">トップへ</a>
		</div>
	</div>
</body>
</html>
