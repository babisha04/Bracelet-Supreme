/*const data=[
    {
    name:"polar", price:"150", category:"pearl"
   }
]*/
 function loadProducts() {
fetch("http://localhost:8080/api/products")
  .then(response => response.json())
  .then(data => {
    const container = document.getElementById("product-list");
    container.innerHTML = "";
    data.forEach(p => {
      container.innerHTML += `
        <div class="card col-md-4 p-3">
          <h5>${p.name}</h5>
          <p>Price: ₹${p.price}</p>
          <p>Quantity: ${p.stock}</p>
          <button class="btn btn-success">Add to Cart</button>
        </div>`;
    });
  })
  .catch(err => console.error("Error:", err));
}
loadProducts();