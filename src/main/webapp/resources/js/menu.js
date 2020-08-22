document.addEventListener("DOMContentLoaded", function() {

    var steps = document.querySelector("#stepsScroll");
    steps.addEventListener("click", function ()
    {
        document.querySelector(".steps").scrollIntoView();
    });

    var about = document.querySelector("#aboutScroll");
    about.addEventListener("click", function ()
    {
        document.querySelector(".about-us").scrollIntoView();
    });

    var help = document.querySelector("#helpScroll");
    help.addEventListener("click", function ()
    {
        document.querySelector(".help").scrollIntoView();
    });

    var contact = document.querySelector("#contactScroll");
    contact.addEventListener("click", function ()
    {
        document.querySelector(".contact").scrollIntoView();
    });

    if (location.hash === "#steps") {
        document.querySelector(".steps").scrollIntoView();
    } else if (location.hash === "#about-us"){
        document.querySelector(".about-us").scrollIntoView();
    } else if (location.hash === "#help") {
        document.querySelector(".help").scrollIntoView();
    } else if (location.hash === "#contact") {
        document.querySelector(".contact").scrollIntoView();
    } else {
        console.log("Something went wrong");
    }
});