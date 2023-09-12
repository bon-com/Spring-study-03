<html>
<head>
	<%@ include file="/WEB-INF/commons/header_common.jsp" %>
</head>
<body>
    <h2>出力画面</h2>
    <div>入力したテキストは</div>
    <div>
        「<span><c:out value="${testForm.text}" /></span>」
    </div>
    <div>です。</div>
    <br>
    <div>
        <a href="<c:url value='hello' />">トップ画面へ戻る</a>
    </div>
</body>
</html>