const urlParams = new URLSearchParams(window.location.search);

if (urlParams.get("login") === "true") {
    var myModal = new bootstrap.Modal(document.getElementById('exampleModal'));
    myModal.show();
}