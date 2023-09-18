<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>PDFファイルアップロード</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">PDFファイルアップロード</h2>
		<div class="container mt-5">
			<form:form modelAttribute="uploadForm" class="mt-4" enctype="multipart/form-data">
				<div class="container mt-5">
					<table class="table table-bordered">
						<tr>
							<th class="col-3">PDFファイル</th>
							<td class="col-7"><input type="file" name="pdfFile" /></td>
						</tr>
					</table>
				</div>
				<div class="form-group text-center">
					<!-- 戻るボタン -->
					<a href="${contextPath}" class="btn btn-danger mr-4 px-5">戻る</a>
					<button type="submit" name="upload" class="btn btn-primary px-5">アップロード</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
