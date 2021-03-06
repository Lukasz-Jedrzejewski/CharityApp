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
                                    <li><a href="/admin/edit-mail/${user.id}">Zmień mail</a></li>
                                    <li><a href="/admin/edit-password/${user.id}">Zmień hasło</a></li>
                <%--                    <li><a href="/admin/users">Zarządzaj użytkownikami</a></li>--%>
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
        <li><a href="/admin/donation-list" class="btn btn--without-border">Donacje</a></li>
        <li><a href="/admin/institution-list" class="btn btn--without-border">Instytucje</a></li>
        <li><a href="/admin/category-list" class="btn btn--without-border">Kategorie</a></li>
        <li><a href="/admin/admin-list" class="btn btn--without-border">Administratorzy</a></li>
        <li><a href="/admin/user-list" class="btn btn--without-border">Użytkownicy</a></li>
    </ul>
</nav>