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
    
        var totalSum = 0;

        for(let i=0;i<carrito_items.length; i++)
        {

            var row= document.createElement("tr");

            var producto=document.createElement("td")
            producto.innerHTML=carrito_items[i]["nombre"];
            totalSum += carrito_items[i]["precio"]

            var precio=document.createElement("td")
            precio.innerHTML=carrito_items[i]["precio"] + "€";

            //var cantidad=document.createElement("td");
            //cantidad.innerHTML=1;


            row.appendChild(producto);
            row.appendChild(precio);
            //row.appendChild(cantidad);

            table.appendChild(row);
        }

        // Create a row for the total sum
        var totalRow = document.createElement("tr");

        var totalLabel = document.createElement("th");
        totalLabel.innerHTML = "TOTAL";

        var totalPrice = document.createElement("th");
        totalPrice.innerHTML = totalSum.toFixed(2) + "€"; // Format the total sum to 2 decimal places

        totalRow.appendChild(totalLabel);
        totalRow.appendChild(totalPrice);

        table.appendChild(totalRow);



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









var check = function() {
    if (document.getElementById('password').value ==
      document.getElementById('password_repeat').value) {
      document.getElementById('message').style.color = 'green';
      document.getElementById('message').innerHTML = 'Las contrasenas son iguales';
      document.getElementById("btn_check_user").disabled = false;

    } else {
      document.getElementById('message').style.color = 'red';
      document.getElementById('message').innerHTML = 'Las contrasenas NO son iguales';
      document.getElementById("btn_check_user").disabled = true;
    }
  }

  var usernameInput = document.getElementById('username');
  usernameInput.addEventListener('keypress', function(event) {
    var regex = /^[a-zA-Z0-9]+$/;
    if (!regex.test(event.key)) {
        event.preventDefault();
      }
  });
  
  var usernameInput = document.getElementById('password');
  usernameInput.addEventListener('keypress', function(event) {
    var regex = /^[a-zA-Z0-9]+$/;
    if (!regex.test(event.key)) {
        event.preventDefault();
      }
  });
  
  var usernameInput = document.getElementById('password_repeat');
  usernameInput.addEventListener('keypress', function(event) {
    var regex = /^[a-zA-Z0-9]+$/;
    if (!regex.test(event.key)) {
        event.preventDefault();
      }
  });
  
  






var btn_buscar_user = document.getElementById("btn_check_user");
btn_buscar_user.addEventListener("click", updateUser);



function updateUser(event) {
    event.preventDefault(); // Evita que se recargue la página

    
    var username= document.getElementById("username").value;
    var password= document.getElementById("password").value;
    var password_repeat= document.getElementById("password_repeat").value;

    const body_html="username="+username+"&password="+password+"&password_repeat="+password_repeat;

    var div = document.getElementById("div_ans");
    div.innerHTML = ""; //quitamos lo que hubiera antes, como la ultima busqueda

    if(!(document.getElementById('username').value.trim() === '') && !(document.getElementById('password').value.trim() === '')){


        fetch("/api/add/pedido", {method:"PUT", body: body_html})
        .then(function(res){
            return res.text();
        })
        .then(function(data)
        {
            alert(data);
            var h4= document.createElement("h4");
            h4.innerHTML=data;
            div.appendChild(h4);
        })
        .catch(function(error)
        {
            var h4= document.createElement("h4");
            h4.innerHTML=error;
            div.appendChild(h4);
        });
    }else{
        var h4= document.createElement("h4");
        h4.innerHTML="Rellene todos los campos";
        div.appendChild(h4);
    }
}



