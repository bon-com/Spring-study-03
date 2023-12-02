<html>
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
</head>
<body>
	<div class="container mt-2">
		<h2 class="text-center">確認画面</h2>
		<form:form modelAttribute="type7Form" class="mt-4">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">名前</th>
						<td class="col-7">${type7Form.student.name}</td>
					</tr>
					<tr>
						<th class="col-3">学年</th>
						<td class="col-7">${type7Form.student.grade}</td>
					</tr>
					<tr>
						<th class="col-3">学級</th>
						<td class="col-7">${type7Form.student.gradeClass}</td>
					</tr>
					<tr>
						<th class="col-3">国語</th>
						<td class="col-7">${type7Form.result.japaneseLang}</td>
					</tr>
					<tr>
						<th class="col-3">算数</th>
						<td class="col-7">${type7Form.result.arithmetic}</td>
					</tr>
				</table>
			</div>
			<div class="d-flex justify-content-center mt-2  mt-4">
				<button type="submit" name="redo" class="btn btn-danger mr-4">戻る</button>
				<button type="submit" name="regist" class="btn btn-primary">登録</button>
			</div>
		</form:form>
	</div>
</body>
</html>