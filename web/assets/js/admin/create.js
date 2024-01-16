console.log("admin/create.js");

//carga DOM
document.addEventListener("DOMContentLoaded", async function () {
    console.log("admin.js ready")

    const toastLiveExample = document.getElementById('liveToast');
    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample);

    document.getElementById("form").addEventListener('submit', create);

    function create(evt) {
        evt.preventDefault();

        console.log('create', evt);

        let name = document.getElementById("name").value
        let radio = document.getElementById("radio").value
        let mass = document.getElementById("mass").value

        fetch('http://localhost:8000/api/planets', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                name: name,
                radio: radio,
                mass: mass
            })
        })
            .then(response => {
                console.log("2");
                //console.log(response);
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })

            .then(result => {//ok
                console.log("3");
                console.log(result);
                // window.location.href = "/admin/index.html";
            })

            .catch(error => {
                console.log("4");
                console.log('error', error)

                toastBootstrap.show()


            });
    }

});
