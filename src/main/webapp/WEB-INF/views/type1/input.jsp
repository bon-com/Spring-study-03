<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/commons/header_common.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<!-- コンテナクラスを追加 -->
		<h2 class="text-center">入力画面</h2>
		<form:form modelAttribute="type1Form" class="mt-4">
			<!-- テキストボックス -->
			<div class="form-group">
				<label for="name">お名前：</label>
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" cssClass="text-danger" />
			</div>

			<!-- 登録コード -->
			<div class="form-group">
				<label for="registerCode">登録コード（半角英数字）：</label>
				<form:input path="registerCode" cssClass="form-control" />
				<form:errors path="registerCode" cssClass="text-danger" />
			</div>

			<!-- 登録年 -->
			<div class="form-group">
				<label for="nregisterYearame">登録年：</label>
				<form:input path="registerYear" cssClass="form-control" />
				<form:errors path="registerYear" cssClass="text-danger" />
			</div>

			<!-- メールアドレス -->
			<div class="form-group">
				<label for="email">メールアドレス：</label>
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" cssClass="text-danger" />
			</div>

			<!-- 数値入力 -->
			<div class="form-group">
				<label for="pocketMoney">お小遣い：</label>
				<form:input path="pocketMoney" type="number" cssClass="form-control" />
				<form:errors path="pocketMoney" cssClass="text-danger" />
			</div>

			<!-- チェックボックス -->
			<div class="form-check mb-4">
				<form:checkbox path="newsletter" cssClass="form-check-input" />
				<label class="form-check-label">ニュースレターを受け取る</label>
			</div>

			<!-- ラジオボタン -->
			<label for="gender">性別：</label>
			<div class="form-check">
				<form:radiobutton path="gender" value="male"
					cssClass="form-check-input" id="male" />
				<label class="form-check-label" for="male">男性</label>
			</div>
			<div class="form-check">
				<form:radiobutton path="gender" value="female"
					cssClass="form-check-input" id="female" />
				<label class="form-check-label" for="female">女性</label>
			</div>
			<div>
				<form:errors path="gender" cssClass="text-danger" />
			</div>

			<!-- 日付入力 -->
			<div class="form-group mt-4 mb-4">
				<label for="birthdate">生年月日：</label>
				<form:input path="birthdate" type="date" cssClass="form-control" />
				<form:errors path="birthdate" cssClass="text-danger" />
			</div>

			<!-- セレクトボックス -->
			<div class="form-group">
				<label for="prefecture">都道府県：</label>
				<form:select path="prefecture" cssClass="form-control"
					items="${prefectures}" itemLabel="prefName" itemValue="id" />
				<form:errors path="prefecture" cssClass="text-danger" />
			</div>

			<!-- 郵便番号 -->
			<div class="form-group mt-4 mb-4">
				<label for="postalCode">郵便番号：</label>
				<div class="input-group">
					<!-- 郵便番号上3桁のテキストボックスの幅を調整 -->
					<div class="col-4">
						<form:input path="postalCode1" size="3" maxlength="3"
							cssClass="form-control" />
					</div>
					<div class="input-group-append">
						<span class="input-group-text">-</span>
					</div>
					<!-- 郵便番号下4桁のテキストボックスの幅を調整 -->
					<div class="col-5">
						<form:input path="postalCode2" size="4" maxlength="4"
							cssClass="form-control" />
					</div>
				</div>
				<div>
					<form:errors path="postalCode1" cssClass="text-danger" />
				</div>
				<div>
					<form:errors path="postalCode2" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="<c:url value='welcome' />" class="btn btn-danger mr-4">戻る</a>

				<!-- 次へボタン -->
				<button type="submit" class="btn btn-primary">次へ</button>
			</div>
		</form:form>
	</div>
</body>
</html>