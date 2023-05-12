
      //SEARCH PERSONA --- GET
      function buscarPedido(){

        /*
        var raw= JSON.stringify({ 
          
          NOMBRE: document.getElementById("NOMBRE").value, 
          APELLIDOS: document.getElementById("APELLIDOS").value,
          EMAIL: document.getElementById("EMAIL").value,
          TELEFONO: document.getElementById("TELEFONO").value }
          );*/
        
        //alert( document.getElementById("NOMBRE").value +"SE ENCUENTRA EN EL SISTEMA");
        
        fetch('http://localhost:8888/data/pedido',
         {
          headers: {
            "Content-Type": "application/json"
          },
           method: "GET",
         })

        .then(response => {
            if (res.ok) {
      
              return(console.log(res.text())); 
              //return res.text();
             
            } else {
              throw new Error("Error petición");
            } 
          })
         
          .catch((error) => {
            console.log(error);
          });S
        };