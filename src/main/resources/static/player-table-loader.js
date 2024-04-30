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
            <th>E-mail:</th>
            <td>${tableRow.dataset.email}</td>
        </tr>
        <tr>
            <th>Magasság:</th>
            <th>${tableRow.dataset.height}</th>
        </tr>
        <tr>
            <th>Testsúly:</th>
            <th>${tableRow.dataset.weight}</th>
        </tr>
        <tr>
            <th>Pozíció:</th>
            <th>${tableRow.dataset.position}</th>
        </tr>
        <tr>
            <th>Minimum fizetési igény:</th>
            <th>${tableRow.dataset.minSalary}</th>
        </tr>
        <tr>
            <th>Milyen kezes:</th>
            <th>${tableRow.dataset.hand}</th>
        </tr>
        <tr>
            <th>Van-e szerzodese:</th>
            <th>${tableRow.dataset.contract}</th>
        </tr>
        <tr>
            <th>Csapat:</th>
            <th>${tableRow.dataset.team}</th>
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