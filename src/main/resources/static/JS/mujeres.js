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
            yourByteArrayAsBase64 = data[i]["photo"];
            img.src = "data:image/png;base64," + yourByteArrayAsBase64;
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

