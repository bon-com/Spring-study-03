<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>テスト結果</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">テスト結果</h2>
		<form:form modelAttribute="type7Form" class="mt-4">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">国語</th>
						<td class="col-7">
							<div class="form-group">
								<form:input path="result.japaneseLang" type="number" cssClass="form-control" />
								<form:errors path="result.japaneseLang" cssClass="text-danger" />
							</div>
						</td>
					</tr>
					<tr>
						<th class="col-3">算数</th>
						<td class="col-7">
							<div class="form-group">
								<form:input path="result.arithmetic" type="number" cssClass="form-control" />
								<form:errors path="result.arithmetic" cssClass="text-danger" />
							</div>
						</td>
					</tr>
				</table>

			</div>
			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="<c:url value="/type7/proceed_menu"/>" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>

</body>
</html>