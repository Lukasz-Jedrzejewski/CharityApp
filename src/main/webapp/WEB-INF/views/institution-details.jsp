<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp" %>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
      integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
      crossorigin=""/>

<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
        integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
        crossorigin=""></script>
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
                    <div class="subtitle">O nas: ${currentInstitution.aboutUs}.</div>
                    <div class="subtitle">Miasto: ${currentInstitution.city}.</div>
                    <div class="subtitle">Ulica: ${currentInstitution.street}.</div>
                    <div class="subtitle">Kod pocztowy: ${currentInstitution.zipCode}.</div>
                    <div class="subtitle">Email: ${currentInstitution.mail}.</div>
                    <div class="subtitle">Telefon: ${currentInstitution.phoneNumber}.</div>
                </div>
            </li>
        </ul>

        <div id="mapid"></div>

        <script>

            var map = L.map('mapid').setView([${cords.lat}, ${cords.lng}], 18);

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            L.marker([${cords.lat}, ${cords.lng}]).addTo(map)
                .bindPopup("Tu jesteśmy")
                .openPopup();

        </script>
    </div>
</section>

<%@include file="footer.jsp" %>
</body>
</html>