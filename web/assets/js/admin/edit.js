console.log("admin/edit.js");

//contenido cargado en el DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin/edit.js ready");


    // Obtener el ID del registro a editar desde la URL
    const urlParams = new URLSearchParams(window.location.search);
    const recordId = urlParams.get('id');

    // Verificar si se proporcionó un ID válido
    if (!recordId) {
        console.error("No se proporcionó un ID de registro válido.");
        return;
    }

    // Cargar los datos del registro actual para la edición
    const recordData = await fetchRecordData(recordId);

    // Verificar si se obtuvo correctamente la información del registro
    if (!recordData) {
        console.error("No se pudo obtener la información del registro para la edición.");
        return;
    }

    // Rellenar el formulario con los datos del registro actual
    populateForm(recordData);

    // Agregar evento de envío del formulario para la actualización
    document.getElementById("formE").addEventListener('submit', update);

    function update(evt) {
        evt.preventDefault();

        let myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        // Obtener los valores actualizados del formulario
        let id = document.getElementById("id").value;
        let name = document.getElementById("name").value;
        let radio = document.getElementById("radio").value;
        let mass = document.getElementById("mass").value;

        let updatedRaw = JSON.stringify({
            id: id,
            name: name,
            radio: radio,
            mass: mass
        });

        let requestOptions = {
            method: 'PUT',
            headers: myHeaders,
            body: updatedRaw,
            redirect: 'follow'
        };

        // Realizar la solicitud de actualización al servidor
        fetch(`http://localhost:8000/api/planets/${recordId}`, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.text();
            })
            .then(result => {
                console.log(result);
                alert("Edición Exitosa");
                // Redirigir a la página de visualización después de la actualización exitosa
                window.location.href = "/admin/index.html";
            })
            .catch(error => console.log('error', error));
    }

    // Función para obtener datos del registro actual
    async function fetchRecordData(id) {
        try {
            const response = await fetch(`http://localhost:8000/api/planets/${id}`);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error fetching record data:', error);
            return null;
        }
    }


    function populateForm(data) {
        document.getElementById("id").value = data.id;
        document.getElementById("name").value = data.name;
        document.getElementById("radio").value = data.radio;
        document.getElementById("mass").value = data.mass;
    }
});




