<html lang="ja">
<head>
	<%@ include file="/WEB-INF/commons/header.jsp" %>
</head>
<body>
	<h2>Hello World!!!!</h2>
	<p>メッセージ： ${msg}</p>
	<ul>
		<%-- 
			<c:url>タグを使うことで、アプリケーションのコンテキストパス + URLになる。
			今回で言うと、「demo04/echo」というURLになる。 
		--%>
		<li><a href="<c:url value="/type1" />">画面遷移タイプ１</a></li>
		<li><a href="<c:url value="/type2/create?form" />">画面遷移タイプ２</a></li>
		<li><a href="<c:url value="/type3/home" />">画面遷移タイプ３</a></li>
	</ul>
</body>
</html>
