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
		<form:form modelAttribute="testForm" class="mt-4">
			<!-- テキストボックス -->
			<div class="form-group">
				<label for="name">お名前：</label>
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" cssClass="text-danger" />
			</div>

			<!-- 登録コード -->
			<div class="form-group">
				<label for="name">登録コード（半角英数字）：</label>
				<form:input path="registerCode"  cssClass="form-control" />
				<form:errors path="registerCode" cssClass="text-danger" />
			</div>

			<!-- 数値入力 -->
			<div class="form-group">
				<label for="age">年齢：</label>
				<form:input path="age" type="number" cssClass="form-control" />
				<form:errors path="age" cssClass="text-danger" />
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
					cssClass="form-check-input" />
				<label class="form-check-label">男性</label>
			</div>
			<div class="form-check mb-4">
				<form:radiobutton path="gender" value="female"
					cssClass="form-check-input" />
				<label class="form-check-label">女性</label>
			</div>

			<!-- 日付入力 -->
			<div class="form-group mb-4">
				<label for="birthdate">生年月日：</label>
				<form:input path="birthdate" type="date" cssClass="form-control" />
				<form:errors path="birthdate" cssClass="text-danger" />
			</div>

			<!-- セレクトボックス -->
			<div class="form-group mb-4">
				<label for="prefecture">都道府県：</label>
				<form:select path="prefecture" cssClass="form-control">
					<form:option value="" label="---" />
					<form:option value="tokyo" label="東京都" />
					<form:option value="osaka" label="大阪府" />
				</form:select>
			</div>

			<!-- 郵便番号 -->
			<div class="form-group mb-4">
				<label for="postalCode">郵便番号：</label>
				<div class="input-group">
					<form:input path="postalCode1" size="3" maxlength="3"
						cssClass="form-control" />
					<div class="input-group-append">
						<span class="input-group-text">-</span>
					</div>
					<form:input path="postalCode2" size="4" maxlength="4"
						cssClass="form-control" />
				</div>
				<form:errors path="postalCode1" cssClass="text-danger" />
				<form:errors path="postalCode2" cssClass="text-danger" />
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">送信</button>
			</div>
		</form:form>
	</div>
</body>
</html>