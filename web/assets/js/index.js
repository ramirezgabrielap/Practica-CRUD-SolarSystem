
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin.js ready");

    // get the amount
    const totalCount = await fetch("http://127.0.0.1:8000/api/planets/count")
        .then(response => response.json())
        .catch(function (error) {
            console.log(error);
        });

    // show
    document.getElementById("countPlanets").innerText = `${totalCount}`;


    // paint the home
    const planets = await fetch("http://127.0.0.1:8000/api/planets")
        .then(response => response.json())
        .catch(function (error) {
            console.log(error);
            toastr["error"]("el universo no existe")
        });

    // paint Cards
    const cardContainer = document.getElementById("card-container");

    planets.forEach(planet => {
        console.log(planet);

        const col = document.createElement("div");
        col.className = "col-3 mb-4";

        const card = document.createElement("div");
        card.className = "card";

        const cardBody = document.createElement("div");
        cardBody.className = "card-body";

        const cardTitle = document.createElement("h5");
        cardTitle.className = "card-title";
        cardTitle.innerText = `ID ${planet.id} ${planet.name}`;

        const cardText = document.createElement("p");
        cardText.className = "card-text";
        cardText.innerText = `Radio: ${planet.radio}
        Masa: ${planet.mass}`;

        cardBody.appendChild(cardTitle);
        cardBody.appendChild(cardText);

        card.appendChild(cardBody);
        col.appendChild(card);
        cardContainer.appendChild(col);
    });
});
