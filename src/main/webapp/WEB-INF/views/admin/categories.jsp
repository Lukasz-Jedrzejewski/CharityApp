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
                <c:forEach items="${categoryList}" var="category">
                    <li>
                        <div class="col">
                            <div class="title">Nazwa: ${category.name}</div>
                            <div>
                                <a href="/admin/category-add/${category.id}"
                                   class="btn btn--without-border active">Edycja</a>
                                <a href="/admin/category-delete/${category.id}"
                                   class="btn btn--without-border active">Usuwanie</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
                <li>
                    <div class="btn"><a href="/admin/category-add">Dodaj kategorię</a></div>
                </li>
            </ul>
        </div>
    </section>
</header>
</body>
</html>