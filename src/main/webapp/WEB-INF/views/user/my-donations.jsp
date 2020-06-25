<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../header.jsp"%>
<body>
<header class="header--form-page">
    <%@include file="user-menu.jsp"%>

    <section class="help">
        <div class="help--slides active" data-id="1">
            <ul class="help--slides-items">
                <c:forEach items="${myDonations}" var="myDon" >
                <li>
                        <div class="col">
                            <div class="title">Data utworzenia: ${myDon.created}</div>
                            <c:forEach items="${myDon.categories}" var="category">
                                <div class="title">Kategorie: ${category.name}</div>
                            </c:forEach>
                            <div class="title">Worków: ${myDon.quantity}</div>
                            <div class="title">Dla: ${myDon.institution.name}</div>
                            <div class="title">Adres: ${myDon.city}, Ulica: ${myDon.street}, Kod pocztowy: ${myDon.zipCode}</div>
                            <div class="title">Mój komentarz: ${myDon.pickUpComment}</div>
                            <div class="title">Data odbioru: ${myDon.pickUpDate} Godzina: ${myDon.pickUpTime}</div>
                            <div class="title">
                                Status: <c:if test="${myDon.picked == false}">Nieodebrane<a href="/user/set-status/${myDon.id}" class="btn btn--without-border active">Odebrano</a></c:if>
                                <c:if test="${myDon.picked == true}">Odebrane</c:if>
                            </div>
                        </div>
                </li>
                </c:forEach>
            </ul>
        </div>
    </section>
</header>
</body>
</html>