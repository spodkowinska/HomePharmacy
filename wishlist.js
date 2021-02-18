const pillNameWishlist = document.querySelector('.wishlist-tbody');
async function getData() {
    await fetch('http://localhost:8080/medicine/showWishlist', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            data.map((value, idx) => {
                let trEl = document.createElement('tr');
                let tdName = document.createElement('td')
                let tdDescription = document.createElement('td')
                let tdIcon = document.createElement('td')
                let icon = document.createElement('img')
                icon.className = "icon"
                icon.src = "delete.png"
                tdIcon.appendChild(icon)
                let icon1 = document.createElement('img')
                icon1.className = "icon"
                icon1.src = "blackplus.png"
                tdIcon.appendChild(icon1)
                tdName.innerHTML = value['name']
                tdDescription.innerHTML = value['description']
                trEl.appendChild(tdName)
                trEl.appendChild(tdDescription)
                trEl.appendChild(tdIcon)
                pillNameWishlist.appendChild(trEl)
            })
        })
}
getData()