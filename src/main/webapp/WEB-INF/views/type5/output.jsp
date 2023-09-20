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
					<th class="col-3">同意確認</th>
					<td class="col-7">${type5Form.isAccept}</td>
				</tr>
				<tr>
					<th class="col-3">認証者確認</th>
					<td class="col-7">${userType}</td>
				</tr>
			</table>
		</div>
		<div class="form-group text-center">
			<!-- 戻るボタン -->
			<a href="${contextPath}type5/input?redo" class="btn btn-danger">戻る</a>

		</div>

		<div class="d-flex justify-content-center mt-2">
			<a href="${contextPath}type5/menu">メニューへ</a>
		</div>
	</div>
	</div>
</body>
</html>