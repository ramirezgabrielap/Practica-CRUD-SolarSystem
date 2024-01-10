console.log("admin/create.js");

//contenido cargado en el DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin.js ready")

    document.getElementById("form").addEventListener('submit', create);

    function create(evt) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let name = document.getElementById("name").value
        let radio = document.getElementById("radio").value
        let mass = document.getElementById("mass").value
        console.log(name);
        let raw = JSON.stringify({
            name: name,
            radio: radio,
            mass: mass
        });

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8000/api/planets", requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.text();
            })

            .then(result => {
                console.log(result);
                window.location.href = "/admin/index.html";
            })

            .catch(error => console.log('error', error));
    }

});
