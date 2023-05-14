

function cargarProductos()
{
    var div=document.getElementById("div_productos");
    div.innerHTML="";

    fetch("/accesorios",{method:"GET"})
    .then(function(res){
        return res.text();
    })
    .then(function(data)
    {
        
        let accesorios = JSON.parse(data);
        

        let n_grids= Math.ceil(accesorios.length/3);

        for(let i=0;i<accesorios.length; i++)
        {

            var divProduct= document.createElement("div");
            divProduct.className="produtLayout";

            let img= document.createElement("img");
            img.src=accesorios[i]["dir_image"];
            img.classList="photo";
            
            let title= document.createElement("h3");
            title.innerHTML=accesorios[i]["nombre"];
            title.classList="title";
            let price= document.createElement("p");
            price.innerHTML=accesorios[i]["precio"] +" EUR";
            price.classList="price";
            let button= document.createElement("button");
            button.innerHTML="Añadir al carrito";
            button.classList="button";
            button.id="accesorio"+i;
            button.name=accesorios[i]["id"];

            divProduct.appendChild(img);
            divProduct.appendChild(title);
            divProduct.appendChild(price);
            divProduct.appendChild(button);
            div.appendChild(divProduct);

        }

    })
    .catch(function(error)
    {
        let error_p=document.createElement("p");
        error_p.innerHTML="Error al acceder a la pagina web, por favor intentelo mas tarde."
        div.appendChild("error_p");
    })
};

    
var body= document.body;
body.addEventListener(onload, cargarProductos());


function añadirAlCarrito(id)
{
    
}