console.log("admin/index.js");

//contenido cargado en el DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin.js ready")

    let planets = await fetch("http://127.0.0.1:8000/api/planets")
        .then(response => response.json())
        .catch(function (error) { console.log(error) });

    console.log(planets);


    let tbody = document.getElementById("tbody");


    planets.forEach(planet => {
        console.log(planet);
        let tr = '<tr>';
        tr += '<th scope="row">' + planet.id + '</th>';
        tr += '<td>' + planet.name + '</td>';
        tr += '<td>' + planet.radio + '</td>';
        tr += '<td>' + planet.mass + '</td>';
        tr += '<td>';
        tr += '<a href="edit.html?id=' + planet.id + '" class="btn btn-sm btn-outline-warning mr-1">';
        tr += '<i class="bi bi-pencil-square"></i>';
        tr += '</a>';
        tr += '<button type="button" class="btn btn-sm btn-outline-danger" onclick="deletePlanet(' + planet.id + ')">';
        tr += '<i class="bi bi-trash3"></i>';
        tr += '</button>';
        tr += '</td>';
        tr += '</tr>';
        console.log(tr);
        tbody.innerHTML += tr;
    });

    window.deletePlanet = function (planetId) {
        const confirmation = confirm("¿Estás seguro de eliminar este registro?");
        if (confirmation) {
            fetch("http://127.0.0.1:8000/api/planets/" + planetId, {
                method: 'DELETE'
            })
                .then(response => response.text())
                .then(result => {
                    console.log(result);
                    alert("Eliminación exitosa");
                    // Recargar la página después de la eliminación
                    location.reload();
                })
                .catch(error => console.log('error', error));
        }
    };


});