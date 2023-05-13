window.onload = function getProductos()
{
  var headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
  fetch("api/ropaMujer", {
    method: 'GET',
    headers: headers
  })
  .then(response => response.json())
  .then(data =>{

    let html1="";
    html1 += `<img src="${data[0].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[0].nombre}</h3>`+
             `<p>$${data[0].precio}</p>`+
             `<button onclick="${anadirCarrito()}"> Añadir al carrito </button>`

    document.getElementById("prenda1").innerHTML = html1;

    let html2="";
    html2 += `<img src="${data[1].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[1].nombre}</h3>`+
             `<p>$${data[1].precio}</p>`+
             `<button> Añadir al carrito </button>`
    document.getElementById("prenda2").innerHTML = html2;

    let html3="";
    html3 += `<img src="${data[2].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[2].nombre}</h3>`+
             `<p>$${data[2].precio}</p>`+
             `<button> Añadir al carrito </button>`
    document.getElementById("prenda3").innerHTML = html3;

    let html4="";
    html4 += `<img src="${data[3].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[3].nombre}</h3>`+
             `<p>$${data[3].precio}</p>`+
             `<button> Añadir al carrito </button>`

    document.getElementById("prenda4").innerHTML = html4;

    let html5="";
    html5 += `<img src="${data[4].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[4].nombre}</h3>`+
             `<p>$${data[4].precio}</p>`+
             `<button> Añadir al carrito </button>`
    document.getElementById("prenda5").innerHTML = html5;

    let html6="";
    html6 += `<img src="${data[5].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[5].nombre}</h3>`+
             `<p>$${data[5].precio}</p>`+
             `<button> Añadir al carrito </button>`
    document.getElementById("prenda6").innerHTML = html6;
  })

}



function anadirCarrito()
{


}