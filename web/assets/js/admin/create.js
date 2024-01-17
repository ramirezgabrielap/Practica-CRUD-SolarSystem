console.log("admin/create.js");

//carga DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin.js ready")


    document.getElementById("form").addEventListener('submit', create);

    function create(evt) {
        evt.preventDefault();
        console.log('create', evt);

        //clear bostrap error
        document.getElementById("name").classList.remove('is-invalid');
        document.getElementById("radio").classList.remove('is-invalid');
        document.getElementById("mass").classList.remove('is-invalid');


        fetch('http://localhost:8000/api/planets', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept-Language': 'en_US'
            },
            body: JSON.stringify({
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

            .then(result => {//ok or 400
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

});


