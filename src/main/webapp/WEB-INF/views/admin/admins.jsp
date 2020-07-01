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
                <c:forEach items="${adminList}" var="admin">
                    <li>
                        <div class="col">
                            <div class="title">Dane personalne: ${admin.firstName} ${admin.lastName}</div>
                            <div class="subtitle">Mail: ${admin.email} status:
                                <c:if test="${admin.enabled == true}">aktywny</c:if>
                                <c:if test="${admin.enabled == false}">nieaktywny</c:if>
                            </div>
                            <div>
                                <a href="/admin/admin-add/${admin.id}"
                                   class="btn btn--without-border active">Edycja</a>
                                <a href="/admin/admin-delete/${admin.id}"
                                   class="btn btn--without-border active">Usuwanie</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
                <li>
                    <div class="btn"><a href="/admin/admin-add">Dodaj admina</a></div>
                </li>
            </ul>
        </div>
    </section>
</header>
</body>
</html>