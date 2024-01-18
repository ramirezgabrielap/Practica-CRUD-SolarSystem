console.log("admin/edit.js");

//load content into the DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin/edit.js ready");


    // ID -> URL
    const urlParams = new URLSearchParams(window.location.search);
    const recordId = urlParams.get('id');

    // ID valid
    if (!recordId) {
        console.error("No se proporcionó un ID de registro válido.");
        return;
    }

    // Load data for editing
    const recordData = await fetchRecordData(recordId);

    if (!recordData) {
        console.error("No se pudo obtener la información del registro para la edición.");
        return;
    }

    // form
    populateForm(recordData);


    // Add form submit event for update
    document.getElementById("formE").addEventListener('submit', update);

    function update(evt) {
        evt.preventDefault();
        console.log('update', evt);

        //clear boostrap error
        document.getElementById("name").classList.remove('is-invalid');
        document.getElementById("radio").classList.remove('is-invalid');
        document.getElementById("mass").classList.remove('is-invalid');


        fetch(`http://localhost:8000/api/planets/${recordId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'Accept-Language': 'en_US'
            },
            body: JSON.stringify({
                id: document.getElementById("id").value,
                name: document.getElementById("name").value,
                radio: document.getElementById("radio").value,
                mass: document.getElementById("mass").value
            })
        })
            .then(response => {
                if (!response.ok && response.status != 400) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(result => {
                console.log({ result });
                if (result.status == 400) {
                    toastr["error"]("Input Error!")
                    result.errors.forEach(error => {
                        console.log(error);
                        console.log(error.field, error.defaultMessage);
                        document.getElementById(error.field).classList.add('is-invalid');
                        document.getElementById(error.field + '_error').innerHTML = error.defaultMessage;
                    });
                    return false;
                }

                window.location.href = "/admin/index.html";
            })
            .catch(error => {
                console.log({ error })
                toastr["error"]("Error!")
            });
    }

    // Get data from current record
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
            toastr["error"]("Error fetching record data!")
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




