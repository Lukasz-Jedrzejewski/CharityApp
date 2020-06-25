<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp"%>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj
                <sec:authorize access="isAuthenticated()">
                    ${user.email}
                </sec:authorize>
                <ul class="dropdown">
                    <li><a href="/user/panel">Profil</a></li>
                    <li><a href="/user/user-edit/${user.id}">Edytuj dane</a></li>
                    <li><a href="/user/edit-pass/${user.id}">Zmień hasło</a></li>
                    <li><a href="/user/my-donations">Moje donacje</a></li>
                    <li>
                        <nav>
                            <sec:authorize access="isAuthenticated()">
                                <form action="<c:url value="/logout"/>" method="post">
                                    <button class="btn" type="submit">Wyloguj</button>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </sec:authorize>
                        </nav
                        >
                    </li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
            informacje o odbiorze.
        </h2>
    </div>
</header>

<%@include file="footer.jsp"%>
</body>
</html>
