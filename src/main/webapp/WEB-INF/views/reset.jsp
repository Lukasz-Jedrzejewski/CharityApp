<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp"%>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/about">Zaloguj</a></li>
            <li class="highlighted"><a href="/register">Załóż konto</a></li>
        </ul>

        <%@include file="menu-list.jsp"%>
    </nav>
</header>

<section class="login-page">
    <h2>Podaj swój adres e-mail</h2>
    <form:form action="/reset-pass" method="post" modelAttribute="userModel">
        <div class="form-group">
            <input type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wyślij</button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>
</section>

</body>
</html>