document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault();
    // Getting form data
    const formData = {
        rollNumber: document.getElementById('rollNumber').value,
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        major: document.getElementById('major').value,
        dob: document.getElementById('dob').value,
        phone: document.getElementById('phone').value,
        gender: document.getElementById('gender').value,
        address: document.getElementById('address').value
    };

    const apiUrl = `https://studentmanagementapp-production.up.railway.app/students/${formData.rollNumber}`;

    // Make API call
    fetch(apiUrl, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response from the server
        console.log('Success:', data);
        alert("student updated successfully");
        window.open("index.html");
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});
