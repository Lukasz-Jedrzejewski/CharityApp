<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" method="post">
        <div class="form-group">
            <input type="text" name="firstName" placeholder="first name" />
        </div>
        <div class="form-group">
            <input type="text" name="lastName" placeholder="last name" />
        </div>
        <div class="form-group">
            <input type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" id="psw" name="password" placeholder="Hasło" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" />
        </div>
        <div class="form-group">
            <form:password path="password2" placeholder="Powtórz hasło" />
            <form:errors path="password2"/>
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
            <a href="/about" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<script src="<c:url value="/resources/js/valid.js"/>"></script>

<%@include file="footer.jsp"%>
</body>
</html>

