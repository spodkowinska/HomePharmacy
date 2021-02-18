const pillNameMedicines = document.querySelector('.medicines-tbody');
async function getData() {
    await fetch('http://localhost:8080/medicine/list', {
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
                let tdNotes = document.createElement('td')
                let tdPeople = document.createElement('td')
                let tdBadges = document.createElement('td')
                let tdActions = document.createElement('td')

                let icon = document.createElement('img')
                icon.className = "icon"
                icon.src = "person.png"
                tdPeople.appendChild(icon)

                let icon1 = document.createElement('img')
                icon1.className = "icon"
                icon1.src = "icon-list.png"
                tdActions.appendChild(icon1)

                let icon2 = document.createElement('img')
                icon2.className = "icon"
                icon2.src = "description.png"
                tdActions.appendChild(icon2)

                let icon3 = document.createElement('img')
                icon3.className = "icon"
                icon3.src = "pen.png"
                tdActions.appendChild(icon3)

                let icon4 = document.createElement('img')
                icon4.className = "icon"
                icon4.src = "wishlist.png"
                tdActions.appendChild(icon4)

                let icon5 = document.createElement('img')
                icon5.className = "icon"
                icon5.src = "delete.png"
                tdActions.appendChild(icon5)

                let icon6 = document.createElement('img')
                icon6.className = "icon"
                icon6.src = "blackplus.png"
                tdActions.appendChild(icon6)


                
                tdName.innerHTML = value['name']
                tdNotes.innerHTML = value['description']

                trEl.appendChild(tdName)
                trEl.appendChild(tdNotes)
                trEl.appendChild(tdPeople)
                trEl.appendChild(tdBadges)
                trEl.appendChild(tdActions)
                pillNameMedicines.appendChild(trEl)
            })
        })
}
getData()