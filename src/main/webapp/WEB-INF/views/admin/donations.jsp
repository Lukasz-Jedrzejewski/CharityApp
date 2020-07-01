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
                <c:forEach items="${donationList}" var="donation">
                    <li>
                        <div class="col">
                            <div class="title">Data utworzenia: ${donation.created}</div>
                            <c:forEach items="${donation.categories}" var="category">
                                <div class="title">Kategorie: ${category.name}</div>
                            </c:forEach>
                            <div class="title">Worków: ${donation.quantity}</div>
                            <div class="title">Dla: ${donation.institution.name}</div>
                            <div class="title">Adres: ${donation.city}, Ulica: ${donation.street}, Kod pocztowy: ${donation.zipCode}</div>
                            <div class="title">Mój komentarz: ${donation.pickUpComment}</div>
                            <div class="title">Data odbioru: ${donation.pickUpDate} Godzina: ${donation.pickUpTime}</div>
                            <div class="title">
                                Status: <c:if test="${donation.picked == false}">Nieodebrane</c:if>
                                <c:if test="${donation.picked == true}">Odebrane</c:if>
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