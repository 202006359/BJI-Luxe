const datos_stock = [];  
const datos_pedido = [];  
window.onload = function getProductos()
{
  var headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
  fetch("http://localhost:8080/api/ropaMujer", {
    method: 'GET',
    headers: headers
  })
  .then(response => response.json())
  .then(data =>{

  
    let html1="";
    html1 += `<img src="${data[0].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[0].nombre}</h3>`+
             `<p>$${data[0].precio}</p>` 
   
    document.getElementById("prenda1").innerHTML = html1;

    let html2="";
    html2 += `<img src="${data[1].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[1].nombre}</h3>`+
             `<p>$${data[1].precio}</p>`
    document.getElementById("prenda2").innerHTML = html2;


    let html3="";
    html3 += `<img src="${data[2].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[2].nombre}</h3>`+
             `<p>$${data[2].precio}</p>`
    document.getElementById("prenda3").innerHTML = html3;

  
    let html4="";
    html4 += `<img src="${data[3].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[3].nombre}</h3>`+
             `<p>$${data[3].precio}</p>`

    document.getElementById("prenda4").innerHTML = html4;


    let html5="";
    html5 += `<img src="${data[4].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[4].nombre}</h3>`+
             `<p>$${data[4].precio}</p>`
    document.getElementById("prenda5").innerHTML = html5;

    let html6="";
    html6 += `<img src="${data[5].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[5].nombre}</h3>`+
             `<p>$${data[5].precio}</p>`
    document.getElementById("prenda6").innerHTML = html6;
    datos_stock.push(data);
    //console.log(datos);
    //console.log(datos[0][3].nombre);
    //console.log("HOOOOLA");
  })

}



async function anadirCarrito(param)
{
 try{
  const event = window.event;
  event.preventDefault();
  const pedido = {
    id_producto: datos_stock[0][param].id,
    nombre: datos_stock[0][param].nombre,
    precio: datos_stock[0][param].precio,
  };

  console.log(datos_stock[0][param].id);
  console.log(datos_stock[0][param].nombre);
  console.log(datos_stock[0][param].precio);


  const response = await fetch('http://localhost:8080/api/carrito', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(pedido)
    });

  const data = await response.json();
  console.log(data);
  alert('Guardado');
  

} catch (error) {
  alert('Error en la petición: ' + error.message);
  console.error(error);
}
}
  


function getPedido()
{
  var headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
  fetch("http://localhost:8080/api/getCarrito", {
    method: 'GET',
    headers: headers
  })
  .then(response => response.json())
  .then(data =>{
    //datos_pedido.push(data); 
    let p1 = 0;
    let p2 = 0;
    let p3 = 0;
    let p4 = 0;
    let p5 = 0;
    let p6 = 0;
    console.log(data[0].id_producto);
    for (let i = 0; i < data.length; i++) {
      if(data[i].id_producto==101){p1++;}
      if(data[i].id_producto==102){p2++;}
      if(data[i].id_producto==103){p3++;}
      if(data[i].id_producto==104){p4++;}
      if(data[i].id_producto==105){p5++;}
      if(data[i].id_producto==106){p6++;}
    }

    const cantidades = [p1,p2,p3,p4,p5,p6];
    anadirPedido(cantidades);
})
}


async function anadirPedido(cantidades)
{
 try{
  const event = window.event;
  event.preventDefault();
  const pedido = {
    id_producto: datos_pedido[0][param].id,
    nombre: datos_pedido[0][param].nombre,
    precio: datos_pedido[0][param].precio,
  };

  console.log(datos_pedido[0][param].id);
  console.log(datos_pedido[0][param].nombre);
  console.log(datos_pedido[0][param].precio);

  const response = await fetch('http://localhost:8080/api/pedido', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(pedido)
    });

  const data = await response.json();
  console.log(data);
  alert('Guardado');
  

} catch (error) {
  alert('Error en la petición: ' + error.message);
  console.error(error);
}
}



