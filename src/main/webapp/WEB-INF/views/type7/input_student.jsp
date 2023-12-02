<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>生徒情報</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">生徒情報</h2>
		<form:form modelAttribute="type7Form" class="mt-4">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">名前</th>
						<td class="col-7">
							<div class="form-group">
								<form:input path="student.name" cssClass="form-control" />
								<form:errors path="student.name" cssClass="text-danger" />
							</div>
						</td>
					</tr>
					<tr>
						<th class="col-3">学年</th>
						<td class="col-7">
							<div class="form-group">
								<form:input path="student.grade" type="number" cssClass="form-control" />
								<form:errors path="student.grade" cssClass="text-danger" />
							</div>
						</td>
					</tr>
					<tr>
						<th class="col-3">学級</th>
						<td class="col-7">
							<div class="form-group">
								<form:input path="student.gradeClass" cssClass="form-control" />
								<form:errors path="student.gradeClass" cssClass="text-danger" />
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="form-group text-center mt-4">
				<!-- 戻るボタン -->
				<a href="<c:url value="/type7/proceed_menu"/>" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>

</body>
</html>