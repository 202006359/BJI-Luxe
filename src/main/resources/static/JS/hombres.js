var datos_stock = [];  


function cargarProductos()
{
    var div=document.getElementById("div_productos");
    div.innerHTML="";

    fetch("http://localhost:8080/api/ropaHombre",{method:"GET"})
    .then(function(res){
        return res.text();
    })
    .then(function(data)
    {
        let ropaHombre = JSON.parse(data);   
        //let n_grids= Math.ceil(accesorios.length/3);
        datos_stock.push(ropaHombre);

        for(let i=0;i<ropaHombre.length; i++)
        {

            var divProduct= document.createElement("div");
            divProduct.className="produtLayout";

            let img= document.createElement("img");
            yourByteArrayAsBase64 = ropaHombre[i]["photo"];
            img.src = "data:image/png;base64," + yourByteArrayAsBase64;
            img.classList="photo";
            
            let title= document.createElement("h3");
            title.innerHTML=ropaHombre[i]["nombre"];
            title.classList="title";
            let price= document.createElement("p");
            price.innerHTML=ropaHombre[i]["precio"] +" EUR";
            price.classList="price";
            let button= document.createElement("button");
            button.innerHTML="Añadir al carrito";
            button.classList="button";
            button.id="accesorio"+i;
            button.name=ropaHombre[i]["id"];
            button.addEventListener('click', function(){ añadirAlCarrito(ropaHombre[i]["id"]); }, false);

            divProduct.appendChild(img);
            divProduct.appendChild(title);
            divProduct.appendChild(price);
            divProduct.appendChild(button);
            div.appendChild(divProduct);

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



function añadirAlCarrito(id)
{
    fetch("api/prendaHombre/"+id,{method: "GET"})
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





