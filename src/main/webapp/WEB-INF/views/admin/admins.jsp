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
                    <li>
                        <c:forEach items="${adminList}" var="admin" varStatus="status">
                        <div class="col">
                            <div class="title">Nazwa: ${admin.firstName} : ${admin.lastName}</div>
                            <div class="subtitle">Mail: ${admin.email} aktywny: ${admin.enabled}</div>
                            <div>
                                <a href="/admin/admin-add/${admin.id}"
                                   class="btn btn--without-border active">Edycja</a>
                                <a href="/admin/admin-delete/${admin.id}"
                                   class="btn btn--without-border active">Usuwanie</a>
                            </div>
                        </div>
                        </c:forEach>
                    </li>
                <li>
                    <div class="btn"><a href="/admin/admin-add">Dodaj admina</a></div>
                </li>
            </ul>
        </div>
    </section>
</header>
</body>
</html>