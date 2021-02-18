const pillName = document.querySelector('.expire-table-tbody');
async function getData() {
    await fetch('http://localhost:8080/medicine/listInstances', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => { 
            console.log(data)
            data.map((value, idx) => {
                let trEl = document.createElement('tr')
                let tdName = document.createElement('td')
                let tdQuantityLeft = document.createElement('td')
                let tdExpiryDate = document.createElement('td')
                let tdIcon = document.createElement('td')

                let wishlistIcon = document.createElement('img')
                wishlistIcon.className = "icon"
                wishlistIcon.src = "wishlist.png"
                tdIcon.appendChild(wishlistIcon)
                let deleteIcon = document.createElement('img')
                deleteIcon.src = "delete.png"
                deleteIcon.className = "icon"
                tdIcon.appendChild(deleteIcon)
                
                tdName.innerHTML = value['medicine']['name']
                tdQuantityLeft.innerHTML = value['quantityLeft']
                tdExpiryDate.innerHTML = value['expiryDate']
                
                trEl.appendChild(tdName)
                trEl.appendChild( tdQuantityLeft)
                trEl.appendChild( tdExpiryDate)
                trEl.appendChild(tdIcon)
                pillName.appendChild(trEl)
            })
        })
}
getData()
