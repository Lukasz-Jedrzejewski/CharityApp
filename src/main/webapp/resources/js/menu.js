document.addEventListener("DOMContentLoaded", function() {

    var steps = document.querySelector("#stepsScroll");
    console.log(steps);
    steps.addEventListener("click", function ()
    {
        document.querySelector(".steps").scrollIntoView();
    });
});