console.log("admin/form.js");


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
    });
});


//escuchar evento submit
// tomar todos los campos por id
// llamar a la api http://localhost:8000/api/planets
// metodo POST y pasar la data
// si todo ok redirect a /admin/index.html