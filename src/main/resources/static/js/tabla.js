$(document).ready(function(){
    cargarAlumnos();
});
async function cargarAlumnos(){
    //peticion get post
    const request = await fetch('/listar', {
        method: 'GET',
        headers: {
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const alumnos = await request.json();

    let listadoHTML = "";
    for(let alumno of alumnos ){
        let fila = '<td>' + alumno.id + '</td><td>' + alumno.nombre + '</td><td><button onclick="eliminar(' + alumno.id + ')">Eliminar</td></tr>';
        listadoHTML = listadoHTML + fila;
    }
    document.querySelector('#alumno tbody').outerHTML = listadoHTML;
}
async function eliminar(id){
    const request = await fetch('/eliminar/' + id, {
        method: 'DELETE',
        headers: {
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        },
    });
    location.reload();
}
async function add(){
    let datos= {};
    datos.alumno = document.getElementById('txtAlumno').value;
    const request = await fetch('/add/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    location.reload();
}
function cambiarValorAlumno(){
    document.getElementById('idAlumno').value = id;
    //cambio valor del input por id
}
async function edit(){
    let datos={};
    datos.id = document.getElementById('idAlumnos').value;
    datos.nombre  = document.getElementById('txtNuevoAlumnos').value;
    const request = await fetch('/edit/'+ datos.id +'/'+datos.nombre, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        // body: JSON.stringify(datos)
    });
    location.reload();
}