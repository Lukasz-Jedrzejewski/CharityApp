<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../header.jsp" %>
<body>
<header class="header--form-page">
    <%@include file="admin-menu.jsp" %>
    <section class="login-page">
        <h2>Wpisz dane</h2>
        <form:form action="/admin/admin-add" method="post" modelAttribute="admin">
            <form:hidden path="id"/>
            <div class="form-group">
                <form:input path="firstName" placeholder="first name" />
            </div>
            <div class="form-group">
                <form:input path="lastName" placeholder="last name" />
            </div>
            <div class="form-group">
                <form:input path="email" placeholder="Email" />
            </div>
            <div class="form-group">
                <form:password path="password" placeholder="Hasło" />
            </div>
            <div class="form-group form-group--buttons">
                <button type="submit" class="btn">Potwierdzam</button>
            </div>
        </form:form>
    </section>
</header>
</body>
</html>