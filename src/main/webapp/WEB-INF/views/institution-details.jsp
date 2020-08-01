<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp" %>
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

<section class="help">
    <div class="help--slides active" data-id="1">

        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Fundacja ${currentInstitution.name}</div>
                    <div class="subtitle">Cel i misja: ${currentInstitution.description}.</div>
                </div>
            </li>
        </ul>
    </div>
</section>

<%@include file="footer.jsp" %>
</body>
</html>