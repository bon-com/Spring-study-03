<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <%@ include file="/WEB-INF/commons/header.jsp"%>
    <title>検索操作</title>
</head>
<body>
    <%@ include file="/WEB-INF/commons/header_common.jsp"%>
    <div class="container mt-5">
        <h2 class="text-center mb-4">検索操作</h2>
        <div class="mb-4">
            <ul class="list-group">
                <li class="list-group-item">全検索<a href="${contextPath}type9/user/all" class="ml-2">こちら</a></li>
                <li class="list-group-item">新規登録<a href="${contextPath}type9/user/create" class="ml-2">こちら</a></li>
            </ul>
        </div>
        <c:if test="${not empty user}">
            <table class="table table-bordered">
                <!-- 以下のテーブルの各行を同様に更新 -->
                <tr>
                    <th class="col-3 bg-dark text-white">ID</th>
                    <td class="col-9">${user.id}</td>
                </tr>
                <tr>
                    <th class="col-3 bg-dark text-white">名前</th>
                    <td class="col-9">${user.name}</td>
                </tr>
                <tr>
                    <th class="col-3 bg-dark text-white">メールアドレス</th>
                    <td class="col-9">${user.email}</td>
                </tr>
                <tr>
                    <th class="col-3 bg-dark text-white">誕生日</th>
                    <td class="col-9">${user.birthday}</td>
                </tr>
                <tr>
                    <th class="col-3 bg-dark text-white">出身県</th>
                    <td class="col-9">${user.prefName}</td>
                </tr>
                <!-- 他の行も同様に -->
            </table>
        </c:if>
        <c:if test="${not empty users}">
            <table class="table table-bordered table-striped ">
                <thead>
                    <tr class="bg-dark text-white">
                        <th class="col-2">ID</th>
                        <th class="col-2">名前</th>
                        <th class="col-3">メールアドレス</th>
                        <th class="col-2">誕生日</th>
                        <th class="col-1">出身県</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td><a href="${contextPath}type9/user/${user.id}">${user.id}</a></td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.birthday}</td>
                            <td>${user.prefecture}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <div class="form-group text-center mt-4">
            <a href="${contextPath}" class="btn btn-danger mr-4 px-5">戻る</a>
            <button type="submit" name="send" class="btn btn-primary px-5">次へ</button>
        </div>
    </div>
</body>
</html>
