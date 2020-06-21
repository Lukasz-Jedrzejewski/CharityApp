<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp"%>
<body>
<header class="header--form-page">
    <nav class="container container--70">

        <ul>
            <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Hasła muszą być identyczne!
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step" onclick="history.back()">Wstecz</button>
            </div>
        </h2>
    </div>
</header>

<%@include file="footer.jsp"%>
</body>
</html>