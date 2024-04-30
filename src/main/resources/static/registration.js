const coachSelectRadio = document.getElementById('coach-select-radio');
const playerSelectRadio = document.getElementById('player-select-radio');
const coachEntries = document.getElementsByClassName("coach-entry")
const playerEntries = document.getElementsByClassName("player-entry")

function showCoachEntries() {
    for (const coachEntry of coachEntries) {
        coachEntry.style.display = "table-row"
    }

    for (const playerEntry of playerEntries) {
        playerEntry.style.display = 'none';
    }
}

function showPlayerEntries() {
    for (const coachEntry of coachEntries) {
        coachEntry.style.display = "none"
    }

    for (const playerEntry of playerEntries) {
        playerEntry.style.display = 'table-row';
    }
}

coachSelectRadio.addEventListener('click', showCoachEntries);
playerSelectRadio.addEventListener('click', showPlayerEntries);