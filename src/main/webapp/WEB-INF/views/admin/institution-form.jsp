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
        <form:form action="/admin/institution-add" method="post" modelAttribute="institution">
            <form:hidden path="id"/>
            <div class="form-group form-group--inline">
                <label>
                    Nazwa fundacji: <form:input path="name"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    Opis fundacji: <form:textarea path="description"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    O nas: <form:input path="aboutUs"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    Miasto: <form:input path="city"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    Ulica: <form:input path="street"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    Kod pocztowy: <form:input path="zipCode"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    Email: <form:input path="mail"/>
                </label>
            </div>
            <div class="form-group form-group--inline">
                <label>
                    Numer telefonu: <form:input path="phoneNumber"/>
                </label>
            </div>
            <div class="form-group form-group--buttons">
                <button type="submit" class="btn">Potwierdzam</button>
            </div>
        </form:form>
    </section>
</header>
</body>
</html>