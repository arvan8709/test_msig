document.getElementById('createForm')?.addEventListener('submit', async function (e) {
    e.preventDefault();

    const submitButton = document.getElementById('submitButton');
    submitButton.disabled = true;

    const formData = {
        name: document.getElementById('name').value,
        phoneNumber: document.getElementById('phoneNumber').value,
        email: document.getElementById('email').value,
        address: document.getElementById('address').value
    };

    try {
        const response = await fetch('/api/phonebook/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            alert('Phonebook entry created successfully!');
            window.location.href = '/list.html';
        } else {
            const errorData = await response.json();
            throw new Error(errorData.message);
        }
    } catch (error) {
        console.error('Error creating entry:', error);
        alert('Failed to create the phonebook entry.');
        submitButton.disabled = false;
    }
});

document.getElementById('searchBtn')?.addEventListener('click', async function () {
    const searchName = document.getElementById('searchName').value;

    try {
        const response = await fetch(`/api/phonebook/search?name=${searchName}`);
        const data = await response.json();

        const tableBody = document.querySelector('#phonebookTable tbody');
        tableBody.innerHTML = '';

        data.forEach(entry => {
            tableBody.innerHTML += `
                <tr>
                    <td>${entry.name}</td>
                    <td>${entry.phoneNumber}</td>
                    <td>${entry.email}</td>
                    <td>${entry.address}</td>
                    <td>
                        <a href="/update.html?id=${entry.id}">Edit</a>
                        <a href="/delete.html?id=${entry.id}">Delete</a>
                    </td>
                </tr>
            `;
        });
    } catch (error) {
        console.error('Error fetching data:', error);
        alert('Failed to search phonebook entries.');
    }
});
