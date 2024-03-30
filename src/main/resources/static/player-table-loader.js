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
            <th>E-mail</th>
            <td>${tableRow.dataset.email}</td>
        </tr>
        <tr>
            <th>Magassag</th>
            <th>${tableRow.dataset.height}</th>
        </tr>
        <tr>
            <th>Suly</th>
            <th>${tableRow.dataset.weight}</th>
        </tr>
        <tr>
            <th>Pozicio</th>
            <th>${tableRow.dataset.position}</th>
        </tr>
        <tr>
            <th>Minimum fizetesi igeny</th>
            <th>${tableRow.dataset.minSalary}</th>
        </tr>
        <tr>
            <th>Milyen kezes</th>
            <th>${tableRow.dataset.hand}</th>
        </tr>
        <tr>
            <th>Van-e szerzodese</th>
            <th>${tableRow.dataset.contract}</th>
        </tr>
    `;

    profileModalBody.innerHTML = newRow;
}

const searchResultRows = document.querySelectorAll(".coach-row-table");
for (const row of searchResultRows) {
    row.addEventListener("click", tableClickHandler);
}