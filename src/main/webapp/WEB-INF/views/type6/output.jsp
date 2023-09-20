<html>
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-2">
		<h2 class="text-center">出力画面</h2>
		<div class="container mt-5">
			<table class="table table-bordered">
				<tr>
					<th class="col-3">名前</th>
					<td class="col-7">${type6Form.student.name}</td>
				</tr>
				<tr>
					<th class="col-3">学年</th>
					<td class="col-7">${type6Form.student.grade}年</td>
				</tr>
				<tr>
					<th class="col-3">学級</th>
					<td class="col-7">${type6Form.student.gradeClass}組</td>
				</tr>
				<tr>
					<th class="col-3">国語</th>
					<td class="col-7">${type6Form.result.japaneseLang}点</td>
				</tr>
				<tr>
					<th class="col-3">算数</th>
					<td class="col-7">${type6Form.result.arithmetic}点</td>
				</tr>
			</table>
		</div>
		<div class="form-group text-center">
			<!-- 戻るボタン -->
			<a href="${contextPath}type6/input?redo" class="btn btn-danger">戻る</a>

		</div>

		<div class="d-flex justify-content-center mt-2">
			<a href="${contextPath}type6/menu">メニューへ</a>
		</div>
	</div>
	</div>
</body>
</html>