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
                <c:forEach items="${institutionList}" var="institution" varStatus="status">
                    <c:if test="${status.count %2 != 0}">
                        <br>
                        <div class="col">
                            <div class="title">Fundacja ${institution.name}</div>
                            <div class="subtitle">Cel i misja: ${institution.description}.</div>
                            <div>
                                <a href="/admin/institution-add/${institution.id}" class="btn btn--without-border active">Edycja</a>
                                <a href="/admin/institution-delete/${institution.id}" class="btn btn--without-border active">Usuwanie</a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </li>
            <li>
                <c:forEach items="${institutionList}" var="institution" varStatus="status">
                    <c:if test="${status.count %2 == 0}">
                        <br>
                        <div class="col">
                            <div class="title">Fundacja ${institution.name}</div>
                            <div class="subtitle">Cel i misja: ${institution.description}.</div>
                            <div>
                                <a href="/admin/institution-add/${institution.id}" class="btn btn--without-border active">Edycja</a>
                                <a href="/admin/institution-delete/${institution.id}" class="btn btn--without-border active">Usuwanie</a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </li>
            <li>
                <div class="btn"><a href="/admin/institution-add">Dodaj fundację</a></div>
            </li>
        </ul>
    </div>
    </section>
</header>
</body>
</html>