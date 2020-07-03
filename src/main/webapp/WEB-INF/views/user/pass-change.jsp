<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../header.jsp" %>
<body>
<header class="header--form-page">
    <%@include file="user-menu.jsp" %>
    <section class="login-page">
        <h2>Wpisz dane</h2>
        <form:form action="/user/edit-pass" method="post" modelAttribute="userPass">
            <form:hidden path="id"/>
            <div class="form-group">
                <form:password path="password" id="psw" placeholder="Hasło" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"/>
            </div>
            <div id="message">
                <h3>Hasło musi składać się z:</h3>
                <p id="letter" class="invalid"><b>małych liter</b></p>
                <p id="capital" class="invalid"><b>dużych liter</b></p>
                <p id="number" class="invalid"><b>cyfr</b></p>
                <p id="length" class="invalid">Minimum <b>8 znaków</b></p>
                <p id="mark" class="invalid"><b>znaków specjalnych @$!%*?&</b></p>
            </div>
            <div class="form-group form-group--buttons">
                <button type="submit" class="btn">Potwierdzam</button>
            </div>
        </form:form>
    </section>
</header>
<script src="<c:url value="/resources/js/valid.js"/>"></script>
</body>
</html>