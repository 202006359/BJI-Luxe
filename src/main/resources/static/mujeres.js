const datos_stock = [];  
const datos_pedido = [];  
window.onload = function getProductos()
{
  var div=document.getElementById("div_productos");
  div.innerHTML="";

  var headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
  fetch("http://localhost:8080/api/ropaMujer", {
    method: 'GET',
    headers: headers
  })
  .then(response => response.json())
  .then(data =>
    {
        //let accesorios = JSON.parse(data);   
        //datos_stock.push(accesorios);

        for(let i=0;i<data.length; i++)
        {
            var divProduct= document.createElement("div");
            divProduct.className="produtLayout";

            let img= document.createElement("img");
            img.src=data[i].url;
            img.classList="photo";
            
            let title= document.createElement("h3");
            title.innerHTML=data[i].nombre;
            title.classList="title";
            let price= document.createElement("p");
            price.innerHTML=data[i].precio +" EUR";
            price.classList="price";
            let button= document.createElement("button");
            button.innerHTML="Añadir al carrito";
            button.classList="button";
            button.id="accesorio"+i;
            button.name=data[i].id;
            button.addEventListener('click', function(){ añadirAlCarrito(data[i].id); }, false);

            divProduct.appendChild(img);
            divProduct.appendChild(title);
            divProduct.appendChild(price);
            divProduct.appendChild(button);
            div.appendChild(divProduct);

        }

    /*let html1="";
    html1 += `<img src="${data[0].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[0].nombre}</h3>`+
             `<h3>${data[0].precio} EUR</h3>` 
   
    document.getElementById("prenda1").innerHTML = html1;

    let html2="";
    html2 += `<img src="${data[1].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[1].nombre}</h3>`+
             `<h3>${data[1].precio} EUR</h3>`
    document.getElementById("prenda2").innerHTML = html2;
  
    let html3="";
    html3 += `<img src="${data[2].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[2].nombre}</h3>`+
             `<h3>${data[2].precio} EUR</h3>`
    document.getElementById("prenda3").innerHTML = html3;
 
    let html4="";
    html4 += `<img src="${data[3].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[3].nombre}</h3>`+
             `<h3>$${data[3].precio} EUR</h3>`

    document.getElementById("prenda4").innerHTML = html4;

    let html5="";
    html5 += `<img src="${data[4].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[4].nombre}</h3>`+
             `<h3>${data[4].precio} EUR</h3>`
    document.getElementById("prenda5").innerHTML = html5;

    let html6="";
    html6 += `<img src="${data[5].url}" alt="Mujer 3" height="300em" >`+
             `<h3>${data[5].nombre}</h3>`+
             `<h3>${data[5].precio} EUR</h3>`
    document.getElementById("prenda6").innerHTML = html6;
    let button= document.createElement("button");
    button.innerHTML="Añadir al carrito";
    button.classList="button";
    button.id="accesorio"+i;
    button.name=accesorios[i]["id"];
    button.addEventListener('click', function(){ añadirAlCarrito(accesorios[i]["id"]); }, false);
    datos_stock.push(data);
    //console.log(datos);
    //console.log(datos[0][3].nombre);
    //console.log("HOOOOLA");
    */
  })

}

function añadirAlCarrito(id)
{
    fetch("api/prenda/"+id,{method: "GET"})
    .then(function(res){
        return res.text();
    })
    .then(function(ans)
    {
        let data= JSON.parse(ans);
        var carrito = {
            id_producto: data.id,
            nombre: data.nombre,
            precio: data.precio,
          };

    fetch('http://localhost:8080/api/carrito', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},   body: JSON.stringify(carrito)  })
    console.log(carrito);
    alert("El producto ha sido agreado al carrito con exito");
    })
    .catch(function(error)
    {
        alert("Ha ocurrido un error, por favor refresca la pagina y vuelva a intentarlo.");
        console.log(error);
    })
};

/*
async function anadirCarrito(param)
{
console.log(datos_stock);
 try{
  const event = window.event;
  event.preventDefault();
  const carrito = {
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
    body: JSON.stringify(carrito)
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
    let p1 = 0, p2 = 0,p3 = 0,p4 = 0,p5 = 0,p6 = 0;
    console.log(data[0].id_producto);
    for (let i = 0; i < data.length; i++) {
      if(data[i].id_producto==101){
        datos_pedido.push([data[i].id_producto,data[i].nombre])
        p1++;
      }
      if(data[i].id_producto==102){
        datos_pedido.push([data[i].id_producto,data[i].nombre])
        p2++;
      }
      if(data[i].id_producto==103){
        datos_pedido.push([data[i].id_producto,data[i].nombre])
        p3++;
      }
      if(data[i].id_producto==104){
        datos_pedido.push([data[i].id_producto,data[i].nombre])
        p4++;
      }
      if(data[i].id_producto==105){
        datos_pedido.push([data[i].id_producto,data[i].nombre])
        p5++;
      }
      if(data[i].id_producto==106){
        datos_pedido.push([data[i].id_producto,data[i].nombre])
        p6++;
      }
    }
    console.log(datos_pedido);
    const cantidades = [p1,p2,p3,p4,p5,p6];
    console.log(cantidades);
    anadirPedido(cantidades);

})
}


async function anadirPedido(cantidades)
{
 try{
  const event = window.event;
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

//anadir pedido

*/

