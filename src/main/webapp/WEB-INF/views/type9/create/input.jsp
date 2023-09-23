<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>新規登録</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center mb-4">新規登録</h2>
		<form:form modelAttribute="createUserForm" class="mt-4">
			<table class="table table-bordered">
				<tr>
					<th class="col-3">名前</th>
					<td class="col-7">
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" cssClass="text-danger" />
					</td>
				</tr>
				<tr>
					<th class="col-3">メールアドレス</th>
					<td class="col-7">
						<form:input path="email" cssClass="form-control" />
						<form:errors path="email" cssClass="text-danger" />
					</td>
				</tr>
				<tr>
					<th class="col-3">生年月日</th>
					<td class="col-7">
						<form:input type="date" path="birthday" cssClass="form-control" />
						<form:errors path="birthday" cssClass="text-danger" />
					</td>
				</tr>
				<tr>
					<th class="col-3">出身</th>
					<td class="col-7">
						<form:select path="prefecture" cssClass="form-control" items="${prefectures}" itemLabel="prefName" itemValue="id" />
						<form:errors path="prefecture" cssClass="text-danger" />
					</td>
				</tr>
			</table>
			<div class="form-group text-center mt-4">
				<a href="${contextPath}type9/user/back-action" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="register-request" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>
</body>
</html>
