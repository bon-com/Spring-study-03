<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<%@ include file="/WEB-INF/commons/header.jsp"%>
	<title>顧客情報編集</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">顧客情報編集</h2>
		<form:form modelAttribute="editForm" class="mt-4">
			<div class="container mt-5">
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
							<form:input type="date" path="birthDay" cssClass="form-control" />
							<form:errors path="birthDay" cssClass="text-danger" />
						</td>
					</tr>
					<tr>
						<th class="col-3">好きな数字</th>
						<td class="col-7">
							<form:input type="number" path="favoriteNum" cssClass="form-control" />
							<form:errors path="favoriteNum" cssClass="text-danger" />
						</td>
					</tr>
					<tr>
						<th class="col-3">出身</th>
						<td class="col-7">
							<form:select path="prefecture" cssClass="form-control"
								items="${prefectures}" itemLabel="prefName" itemValue="id" />
							<form:errors path="prefecture" cssClass="text-danger" />
						</td>
					</tr>
				</table>
			</div>
			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="${contextPath}type3/home" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="confirm" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>
	
</body>
</html>