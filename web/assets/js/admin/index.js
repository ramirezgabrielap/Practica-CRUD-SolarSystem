console.log("admin/index.js");

//contenido cargado en el DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin.js ready")

    loadPlanets();

    async function loadPlanets() {
        document.getElementById("tbody").innerHTML = "";
        let planets = await fetch("http://127.0.0.1:8000/api/planets")
            .then(response => response.json())
            .catch(function (error) {
                console.log(error);
                toastr["error"]("error al obtener los planetas");
            });


        let tbody = document.getElementById("tbody");

        if (!planets) {
            console.log('no planetas');
            return false;
        }

        planets.forEach(planet => {
            //console.log(planet);
            let tr = '<tr>';
            tr += '<th scope="row">' + planet.id + '</th>';
            tr += '<td>' + planet.name + '</td>';
            tr += '<td>' + planet.radio + '</td>';
            tr += '<td>' + planet.mass + '</td>';
            tr += '<td>';
            tr += '<a href="edit.html?id=' + planet.id + '" class="btn btn-sm btn-outline-warning me-2">';
            tr += '<i class="bi bi-pencil-square"></i>';
            tr += '</a>';
            tr += '<button type="button" class="btn btn-sm btn-outline-danger" onclick="deletePlanet(' + planet.id + ')">';
            tr += '<i class="bi bi-trash3"></i>';
            tr += '</button>';
            tr += '</td>';
            tr += '</tr>';
            //console.log(tr);
            tbody.innerHTML += tr;
        });
    }

    /*let page = 1;
    const pageSize = 10;

    function changePage(page) {
        currentPage = page;
        fetchData();
    }

    async function fetchData() {
        const planets = await fetch(`http://127.0.0.1:8000/api/planets?page=${page}&size=${pageSize}`)
            .then(response => response.json())
            .catch(function (error) {
                console.log(error);
                toastr["error"]("el universo no existe")
            });
        renderData(planets);
    }
    */

    window.deletePlanet = function (planetId) {
        const confirmation = confirm("¿Estás seguro de eliminar este registro?");
        if (confirmation) {
            fetch("http://127.0.0.1:8000/api/planets/" + planetId, {
                method: 'DELETE'
            })
                .then(response => response.text())
                .then(result => {
                    console.log(result);
                    toastr["success"]("Planet was removed!");
                    // Recarga pag
                    //location.reload();
                    loadPlanets();
                })
                .catch(error => {
                    console.log('error', error);
                    toastr["error"]("no se pudo eliminar planeta:" + planetId);
                });
        }
    };


});