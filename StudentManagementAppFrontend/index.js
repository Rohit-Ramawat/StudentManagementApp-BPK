//For student registration-->

document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault();
    // Getting form data
    const formData = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        major: document.getElementById('major').value,
        dob: document.getElementById('dob').value,
        phone: document.getElementById('phone').value,
        gender: document.getElementById('gender').value,
        address: document.getElementById('address').value
    };

    const apiUrl = 'https://studentmanagementapp-production.up.railway.app/students';

    // Make API call
    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response from the server
        console.log('Success:', data);
        alert("student added successfully");
        window.location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

//for populating data in the table-->

const apiUrl2 = 'https://studentmanagementapp-production.up.railway.app/students';

        // Function to fetch data from the API and populate the table
        function fetchData() {
            fetch(apiUrl2)
                .then(response => response.json())
                .then(data => {
                    // Get the table body
                    const tbody = document.getElementById('tbody');

                    // Clear existing table rows
                    tbody.innerHTML = '';

                    // Iterate through the data and create table rows
                    data.forEach(item => {
                        const row = document.createElement('tr');
                        row.innerHTML = `
                            <td>${item.rollNumber}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td><button onclick="editRow(${item.rollNumber})">Edit</button></td>
                            <td><button onclick="viewRow(${item.rollNumber})">View</button></td>
                            <td><button onclick="deleteRow(${item.rollNumber})">Delete</button></td>
                        `;
                        tbody.appendChild(row);
                    });
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

        // Function to edit a row 
        function editRow(id) {
            window.open("update.html");
        }

        // Function to view a row 
        function viewRow(id) {
            localStorage.setItem('viewID',id);
            window.open("view.html");
        }

        // Function to delete a row 
        function deleteRow(id) {
            const apiUrl3 = `https://studentmanagementapp-production.up.railway.app/students/${id}`

        fetch(apiUrl3, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((data) => {
                alert("Student Data Deleted Successfully");
                window.location.reload();
            })
            .catch((error) => {
                alert("Unable to delete the Student Data");
            });
    }
        

        // Fetch data when the page loads
        fetchData();
