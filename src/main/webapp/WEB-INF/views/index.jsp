<html lang="ja">
<head>
	<%@ include file="/WEB-INF/commons/header_common.jsp" %>
</head>
<body>
	<h2>Hello World!!!!</h2>
	<p>メッセージ： ${msg}</p>
	<ul>
		<%-- 
			<c:url>タグを使うことで、アプリケーションのコンテキストパス + URLになる。
			今回で言うと、「demo04/echo」というURLになる。 
		--%>
		<li><a href="<c:url value="/test" />">テストアプリケーションへ</a></li>
	</ul>
</body>
</html>
