

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
            let title= document.createElement("p");
            title.innerHTML=accesorios[i]["nombre"];
            title.classList="title";
            let price= document.createElement("p");
            price.innerHTML=accesorios[i]["precio"];
            price.classList="price";
            let button= document.createElement("button");
            button.innerHTML="Añadir al carrito";
            button.classList="button";

            divProduct.appendChild(img);
            divProduct.appendChild(title);
            divProduct.appendChild(price);
            divProduct.appendChild(button);
            div.appendChild(divProduct);

        }

    })
    .catch(function(error)
    {
        
    })
};

    
var body= document.body;
body.addEventListener(onload, cargarProductos());
