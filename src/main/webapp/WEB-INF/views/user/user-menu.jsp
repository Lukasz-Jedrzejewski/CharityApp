<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="container container--70">
    <ul class="nav--actions">
        <li class="logged-user">
            <sec:authorize access="isAuthenticated()">
                ${user.email}
            </sec:authorize>
            <ul class="dropdown">
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
        <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="/donate/get" class="btn btn--without-border">Przekaż dary</a></li>
        <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>