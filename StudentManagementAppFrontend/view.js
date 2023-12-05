const rollNumber = localStorage.getItem('viewID');

const apiUrl4 = `https://studentmanagementapp-production.up.railway.app/students/${rollNumber}`;

// Function to fetch data from the API and populate the table
function fetchData() {
    fetch(apiUrl4)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            const pTag = document.getElementById("p");
            pTag.innerHTML = `
                <p>Roll Number: ${data.rollNumber}</p>
                <p>First Name: ${data.firstName}</p>
                <p>Last Name: ${data.lastName}</p>
                <p>Major: ${data.major}</p>
                <p>Date of birth: ${data.dob}</p>
                <p>Enrollment Date: ${data.enrollmentDate}</p>
                <p>Address: ${data.address}</p>
                <p>Phone: ${data.phone}</p>
                <p>Gender: ${data.gender}</p>
            `;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

fetchData();