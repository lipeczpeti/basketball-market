function footerClassHandle() {
    const windowHeight = window.innerHeight;
    const bodyContent = document.querySelector("#body-content");
    const bodyFooter = document.querySelector("#body-footer");

    if (bodyContent.offsetHeight + bodyFooter.offsetHeight > windowHeight) {
        bodyFooter.className = "body-footer-block";
    } else {
        bodyFooter.className = "";
    }
}

window.addEventListener("resize", footerClassHandle);
footerClassHandle();