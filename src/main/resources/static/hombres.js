var datos_pedido = [];  
var datos_stock = [];  
window.onload = function getProductos(){
    
    var headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }
    fetch("http://localhost:8080/api/ropaHombre", {
        method: 'GET',
        headers: headers
    })
    .then(response => response.json())
    .then(data => {
            let html = "";
            for (let i = 0; i < data.length; i++) {
            html += `<div class="prenda">
                        <img src="${data[i].url}" alt="${data[i].nombre}" height="300em" >
                        <h3>${data[i].nombre}</h3>
                        <h3>${data[i].precio} EUR</h3>
                        <button onclick="buscarPedido()">Añadir al carrito</button>
                    </div>`;
            }
            document.getElementById("prendas").innerHTML = html;
            datos_stock.push(data);
    });
}