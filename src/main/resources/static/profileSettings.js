const accountGeneral = document.querySelector("#account-general");
const accountChangePassword = document.querySelector("#account-change-password");
const accountInfo = document.querySelector("#account-info");
const generalLink = document.querySelector("#general-link");
const changePasswordLink = document.querySelector("#change-password-link");
const infoLink = document.querySelector("#info-link");
const typeHiddenInput = document.querySelector("#profile-mod-type");

function showAccountGeneral() {
    typeHiddenInput.value = "account_general"

    accountGeneral.classList.remove("fade");
    accountGeneral.classList.add("show");
    accountGeneral.classList.add("active");
    generalLink.classList.add("active");

    accountChangePassword.classList.remove("show");
    accountChangePassword.classList.remove("active");
    accountChangePassword.classList.add("fade");
    changePasswordLink.classList.remove("active");

    accountInfo.classList.remove("show");
    accountInfo.classList.remove("active");
    accountInfo.classList.add("fade");
    infoLink.classList.remove("active");
}

function showChangePassword() {
    typeHiddenInput.value = "account_change_password"

    accountGeneral.classList.remove("show");
    accountGeneral.classList.remove("active");
    accountGeneral.classList.add("fade");
    generalLink.classList.remove("active");


    accountChangePassword.classList.remove("fade");
    accountChangePassword.classList.add("show");
    accountChangePassword.classList.add("active");
    changePasswordLink.classList.add("active");

    accountInfo.classList.remove("show");
    accountInfo.classList.remove("active");
    accountInfo.classList.add("fade");
    infoLink.classList.remove("active");
}

function showAccountInfo() {
    typeHiddenInput.value = "account_info"

    accountGeneral.classList.remove("show");
    accountGeneral.classList.remove("active");
    accountGeneral.classList.add("fade");
    generalLink.classList.remove("active");


    accountChangePassword.classList.remove("show");
    accountChangePassword.classList.remove("active");
    accountChangePassword.classList.add("fade");
    changePasswordLink.classList.remove("active");

    accountInfo.classList.remove("fade");
    accountInfo.classList.add("show");
    accountInfo.classList.add("active");
    infoLink.classList.add("active");
}

generalLink.addEventListener("click", showAccountGeneral);
changePasswordLink.addEventListener("click", showChangePassword);
infoLink.addEventListener("click", showAccountInfo);

if (window.location.hash === "#account-general") {
    showAccountGeneral();

} else if (window.location.hash === "#account-change-password") {
    showChangePassword();

} else if (window.location.hash === "#account-info") {
    showAccountInfo();
}