<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<%@ include file="/WEB-INF/commons/header.jsp"%>
<title>ページが見つかりません</title>
</head>
<body>
	<%@ include file="/WEB-INF/commons/header_common.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">ページが見つかりません</h2>
		<div class="container mt-5">
			<div class="alert alert-danger" role="alert">
				エラー内容: 申し訳ございませんが、お探しのページは存在しないか、移動された可能性があります。<br/>
			</div>
		</div>
		<div class="d-flex justify-content-center mt-2">
			<a href="${contextPath}/">トップへ</a>
		</div>
	</div>
</body>
</html>
