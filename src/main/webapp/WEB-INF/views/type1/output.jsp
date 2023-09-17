<html>
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
</head>
<body>
	<div class="container mt-2">
		<h2 class="text-center">出力画面</h2>
		<div class="container mt-5">
			<table class="table table-bordered">
				<tr>
					<th class="col-3">お名前</th>
					<td class="col-7">${type1Form.name}</td>
				</tr>
				<tr>
					<th class="col-3">登録コード</th>
					<td class="col-7">${type1Form.registerCode}</td>
				</tr>
				<tr>
					<th class="col-3">お小遣い</th>
					<td class="col-7"><fmt:formatNumber type="currency"
							value="${type1Form.pocketMoney}" currencySymbol="¥"
							maxFractionDigits="0" /></td>
				</tr>
				<tr>
					<th class="col-3">登録年</th>
					<td class="col-7">${type1Form.registerYear}</td>
				</tr>
				<tr>
					<th class="col-3">メールアドレス</th>
					<td class="col-7">${type1Form.email}</td>
				</tr>
				<tr>
					<th class="col-3">ニュースレター</th>
					<td class="col-7">${letterLabel}</td>
				</tr>
				<tr>
					<th class="col-3">性別</th>
					<td class="col-7">${gender}</td>
				</tr>
				<tr>
					<th class="col-3">生年月日</th>
					<td class="col-7"><fmt:formatDate
							value="${type1Form.birthdate}" pattern="yyyy年MM月dd日" /></td>
				</tr>
				<tr>
					<th class="col-3">都道府県</th>
					<td class="col-7">${prefName}</td>
				</tr>
				<tr>
					<th class="col-3">郵便番号</th>
					<td class="col-7">${type1Form.postalCode1}-${type1Form.postalCode2}</td>
				</tr>
			</table>
		</div>
		<div class="form-group text-center">
			<!-- 戻るボタン -->
			<a href="/myapp/type1/redo" class="btn btn-danger">戻る</a>

		</div>

		<div class="d-flex justify-content-center mt-2">
			<a href="<c:url value='welcome' />">トップ画面へ戻る</a>
		</div>
	</div>
	</div>
</body>
</html>