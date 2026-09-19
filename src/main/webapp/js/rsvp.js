document.addEventListener("DOMContentLoaded", function () {

    const rsvpForm = document.getElementById("rsvpForm");

    rsvpForm.addEventListener("submit", function (event) {

        const phone = document.getElementById("phone").value;

        // Simple phone number validation
        if (!/^[0-9]{10}$/.test(phone)) {

            event.preventDefault();

            alert("Please enter a valid 10-digit phone number.");

            return;
        }

        // No preventDefault here!
        // Form will be submitted to Java Servlet.
    });

});

