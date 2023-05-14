

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
        


        console.log(accesorios);
        console.log(accesorios.length);
        let n_grids= Math.ceil(accesorios.length/3);
        console.log(n_grids);
        for(let i=0;i<accesorios.length; i++)
        {
            console.log(accesorios[i].id);
            console.log(accesorios[i]["id"]);
            console.log(accesorios[i]);

        }

    })
    .catch(function(error)
    {
        
    })
};

    
var body= document.body;
body.addEventListener(onload, cargarProductos());
