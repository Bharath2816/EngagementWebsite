document.addEventListener("DOMContentLoaded", function () {


const welcomeScreen =
    document.getElementById("welcomeScreen");

const enterButton =
    document.getElementById("enterButton");

const bgMusic =
    document.getElementById("bgMusic");


enterButton.addEventListener("click", function () {

    // Start music
    bgMusic.play();

    // Hide welcome screen
    welcomeScreen.classList.add("hide");

});


});

/* ================= SCROLL ANIMATION ================= */

const scrollElements =
document.querySelectorAll(".scroll-animation");

const scrollObserver =
new IntersectionObserver(


    function (entries) {

        entries.forEach(function (entry) {

            if (entry.isIntersecting) {

                entry.target.classList.add("show");

                // Animate only once
                scrollObserver.unobserve(entry.target);

            }

        });

    },

    {
        threshold: 0.15
    }

);


scrollElements.forEach(function (element) {


scrollObserver.observe(element);


});





const engagementDate =
new Date("2026-10-25T13:30:00").getTime();

function updateCountdown() {


const now = new Date().getTime();

const difference = engagementDate - now;


if (difference <= 0) {

    document.getElementById("days").innerText = "0";
    document.getElementById("hours").innerText = "0";
    document.getElementById("minutes").innerText = "0";
    document.getElementById("seconds").innerText = "0";

    return;
}


const days = Math.floor(
    difference / (1000 * 60 * 60 * 24)
);

const hours = Math.floor(
    (difference / (1000 * 60 * 60)) % 24
);

const minutes = Math.floor(
    (difference / (1000 * 60)) % 60
);

const seconds = Math.floor(
    (difference / 1000) % 60
);


document.getElementById("days").innerText = days;
document.getElementById("hours").innerText = hours;
document.getElementById("minutes").innerText = minutes;
document.getElementById("seconds").innerText = seconds;


}

updateCountdown();

setInterval(updateCountdown, 1000);
	