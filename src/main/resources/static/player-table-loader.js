const profileModalBody = document.querySelector("#profile-modal-body");

function tableClickHandler(e) {
    const tableRow = e.currentTarget;
    const newRow = `
        <tr>
            <th>Név</th>
            <td>${tableRow.dataset.name}</td>
        </tr>
        <tr>
            <th>Életkor</th>
            <td>${tableRow.dataset.birthday}</td>
        </tr>
        <tr>
            <th>Telefonszám</th>
            <td>${tableRow.dataset.height}</td>
        </tr>
        <tr>
            <th>E-mail</th>
            <td>${tableRow.dataset.email}</td>
        </tr>
    `;

    profileModalBody.innerHTML = newRow;
}

const searchResultRows = document.querySelectorAll(".coach-row-table");
for (const row of searchResultRows) {
    row.addEventListener("click", tableClickHandler);
}