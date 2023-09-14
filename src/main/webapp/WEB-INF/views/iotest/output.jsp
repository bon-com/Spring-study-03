<html>
<head>
<%@ include file="/WEB-INF/commons/header_common.jsp"%>
</head>
<body>
	<div class="container mt-2">
		<h2 class="text-center">出力画面</h2>
		<div class="container mt-5">
			<table class="table table-bordered">
				<tr>
					<th class="col-3">お名前</th>
					<td class="col-7">${testForm.name}</td>
				</tr>
				<tr>
					<th class="col-3">登録コード</th>
					<td class="col-7">${testForm.registerCode}</td>
				</tr>
				<tr>
					<th class="col-3">お小遣い</th>
					<td class="col-7"><fmt:formatNumber type="currency" value="${testForm.pocketMoney}" currencySymbol="¥"/></td>
				</tr>
				<tr>
					<th class="col-3">登録年</th>
					<td class="col-7">${testForm.registerYear}</td>
				</tr>
				<tr>
					<th class="col-3">メールアドレス</th>
					<td class="col-7">${testForm.email}</td>
				</tr>
				<tr>
					<th class="col-3">ニュースレター</th>
					<td class="col-7">${testForm.newsletter}</td>
				</tr>
				<tr>
					<th class="col-3">性別</th>
					<td class="col-7">${testForm.gender}</td>
				</tr>
				<tr>
					<th class="col-3">生年月日</th>
					<td class="col-7"><fmt:formatDate value="${testForm.birthdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<th class="col-3">都道府県</th>
					<td class="col-7">${testForm.prefecture}</td>
				</tr>
				<tr>
					<th class="col-3">郵便番号</th>
					<td class="col-7">${testForm.postalCode1}-${testForm.postalCode2}</td>
				</tr>
			</table>
		</div>
		<div class="d-flex justify-content-center mt-2">
			<a href="<c:url value='hello' />">トップ画面へ戻る</a>
		</div>
	</div>
	</div>
</body>
</html>