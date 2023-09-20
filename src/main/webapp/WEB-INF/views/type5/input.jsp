<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>さまざまなフォームバインド</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">さまざまなフォームバインド</h2>
		<form:form modelAttribute="type5Form" class="mt-4">
			<div class="container mt-5">
				<table class="table table-bordered">
					<tr>
						<th class="col-3">同意確認</th>
						<td class="col-7">
							<div class="form-check">
								<form:checkbox path="isAccept" cssClass="form-check-input" id="isAccept" value="1" />
								<label class="form-check-label" for="isAccept">同意</label>
							</div>
							<form:errors path="isAccept" cssClass="text-danger" />
						</td>
					</tr>
					<tr>
						<th class="col-3">認証者確認</th>
						<td class="col-7">
							<div class="form-group">
								<div class="form-check">
									<form:checkbox path="roles" cssClass="form-check-input" id="roles1" value="1" />
									<label class="form-check-label" for="roles1">利用者</label>
								</div>
								<div class="form-check">
									<form:checkbox path="roles" cssClass="form-check-input" id="roles2" value="2" />
									<label class="form-check-label" for="roles2">管理者</label>
								</div>
								<div class="form-check">
									<form:checkbox path="roles" cssClass="form-check-input" id="roles3" value="3" />
									<label class="form-check-label" for="roles3">承認者</label>
								</div>
								<form:errors path="roles" cssClass="text-danger" />
							</div>
						</td>
					</tr>

				</table>

			</div>
			<div class="form-group text-center">
				<!-- 戻るボタン -->
				<a href="${contextPath}type5/menu" class="btn btn-danger mr-4 px-5">戻る</a>
				<button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
			</div>
		</form:form>
	</div>

</body>
</html>