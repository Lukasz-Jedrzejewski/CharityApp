<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../header.jsp" %>
<body>
<header class="header--form-page">
    <%@include file="admin-menu.jsp" %>
    <section class="help">
        <div class="help--slides active" data-id="1">
            <ul class="help--slides-items">
                <c:forEach items="${userList}" var="user">
                    <li>
                        <div class="col">
                            <div class="title">Dane personalne: ${user.firstName} ${user.lastName}</div>
                            <div class="subtitle">Mail: ${user.email} status:
                                    <c:if test="${user.enabled == true}">aktywny</c:if>
                                    <c:if test="${user.enabled == false}">nieaktywny</c:if>
                                    </div>
                            <div>
                                <a href="/admin/user-add/${user.id}"
                                   class="btn btn--without-border active">Edycja</a>
                                <a href="/admin/user-delete/${user.id}"
                                   class="btn btn--without-border active">Usuwanie</a>
                                <a href="/admin/user-enabled/${user.id}"
                                   class="btn btn--without-border active">Aktywacja</a>
                                <a href="/admin/user-disabled/${user.id}"
                                   class="btn btn--without-border active">Deaktywacja</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </section>
</header>
</body>
</html>