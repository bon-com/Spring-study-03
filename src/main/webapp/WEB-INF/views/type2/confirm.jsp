<html>
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
</head>
<body>
	<div class="container mt-2">
		<h2 class="text-center">確認画面</h2>
		<form method="get">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">名前</th>
						<td class="col-7">${type2Form.name}</td>
					</tr>
					<tr>
						<th class="col-3">年齢</th>
						<td class="col-7">${type2Form.age}</td>
					</tr>
				</table>
			</div>
			<div class="d-flex justify-content-center mt-2">
				<button type="submit" name="redo" class="btn btn-danger mr-4">戻る</button>
				<button type="submit" name="complete" class="btn btn-primary">登録</button>
			</div>
		</form>
	</div>
</body>
</html>