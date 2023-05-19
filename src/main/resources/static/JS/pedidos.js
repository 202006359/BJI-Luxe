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
btn_buscar_user.addEventListener("click", obtenerPedidos);


function obtenerPedidos(event) {
    event.preventDefault(); // Evita que se recargue la página

    
    var username= document.getElementById("username").value;
    var password= document.getElementById("password").value;
    var password_repeat= document.getElementById("password_repeat").value;

    const body_html="username="+username+"&password="+password+"&password_repeat="+password_repeat;

    var div = document.getElementById("div_ans");
    div.innerHTML = ""; //quitamos lo que hubiera antes, como la ultima busqueda

    if(!(document.getElementById('username').value.trim() === '') && !(document.getElementById('password').value.trim() === '')){


        fetch("/pedido", {method:"POST", body: body_html})
        .then(function(res){
            return res.text();
        })
        .then(function(data)
        {
            var totalSum=0;
            var table=document.getElementById("table_prod");
            orden_items=JSON.parse(data);

            console.log(orden_items)
            for(let i=0;i<orden_items.length; i++)
            {
              console.log(orden_items[i]["precio"]);

              var row= document.createElement("tr");
              var producto=document.createElement("td")
              producto.innerHTML=orden_items[i]["nombre"];

              var cantidad=document.createElement("td");
              cantidad.innerHTML=orden_items[i]["cantidad"];

              var precio=document.createElement("td")
              precio.innerHTML=orden_items[i]["precio"] + "€";
              totalSum += orden_items[i]["precio"];

              row.appendChild(producto);
              row.appendChild(cantidad);
              row.appendChild(precio);


              table.appendChild(row);

            }

            var h4= document.createElement("h4");
            h4.innerHTML="Coste total: "+ totalSum + " €";
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



