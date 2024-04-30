const profileModalBody = document.querySelector("#profile-modal-body");
const avatarImg = document.querySelector("#profile-details-avatar");

function tableClickHandler(e) {
    const tableRow = e.currentTarget;
    const newRow = `
        <tr>
            <th>Név:</th>
            <td>${tableRow.dataset.name}</td>
        </tr>
        <tr>
            <th>Életkor:</th>
            <td>${tableRow.dataset.birthday}</td>
        </tr>
        <tr>
            <th>Telefonszám:</th>
            <td>${tableRow.dataset.phoneNumber}</td>
        </tr>
        <tr>
            <th>E-mail:</th>
            <td>${tableRow.dataset.email}</td>
        </tr>
    `;

    profileModalBody.innerHTML = newRow;
    if (tableRow.dataset.avatar && tableRow.dataset.avatar !== "null") {
        avatarImg.src = "/static/" + tableRow.dataset.avatar;
    } else {
        avatarImg.src = "/static/2544.avif";
    }

}

const searchResultRows = document.querySelectorAll(".coach-row-table");
for (const row of searchResultRows) {
    row.addEventListener("click", tableClickHandler);
}