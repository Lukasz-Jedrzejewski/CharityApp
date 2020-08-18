<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp"%>
<body>
<header class="header--form-page">
    <nav class="container container--70">

        <%@include file="menu-list.jsp"%>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Na Twój adres mailowy został wysłany link do zmiany hasła.
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step" onclick="history.back()">Wstecz</button>
            </div>
        </h2>
    </div>
</header>

<%@include file="footer.jsp"%>
</body>
</html>