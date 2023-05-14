var datos_stock = [];  


function cargarProductos()
{
    var table=document.getElementById("table_carrito");
    table.innerHTML="";

    fetch("/api/getCarrito",{method:"GET"})
    .then(function(res){
        return res.text();
    })
    .then(function(data)
    {
        let carrito_items = JSON.parse(data);   
        //let n_grids= Math.ceil(carrito_items.length/3);
        datos_stock.push(carrito_items);
    

        for(let i=0;i<carrito_items.length; i++)
        {

            var row= document.createElement("tr");

            var producto=document.createElement("td")
            producto.innerHTML=carrito_items[i]["nombre"];

            var precio=document.createElement("td")
            precio.innerHTML=carrito_items[i]["precio"];

            //var cantidad=document.createElement("td");
            //cantidad.innerHTML=1;


            row.appendChild(producto);
            row.appendChild(precio);
            //row.appendChild(cantidad);

            table.appendChild(row);
        }

    })
    .catch(function(error)
    {
        console.log(error);
        /*
        let error_p=document.createElement("h2");
        error_p.innerHTML="Error al acceder a la pagina web, por favor intentelo mas tarde."
        div.appendChild("error_p");
        */
    })
};

    
var body= document.body;
body.addEventListener(onload, cargarProductos());
