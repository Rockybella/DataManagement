// scripts.js

// Document ready function to ensure the DOM is fully loaded before executing scripts
document.addEventListener('DOMContentLoaded', function() {
    // Example: Dynamic content update
    // Changing the text content of an element with id 'welcome-message'
    let welcomeMessage = document.getElementById('welcome-message');
    if (welcomeMessage) {
        welcomeMessage.textContent = 'Welcome to FunFit!';
    }

    // Example: Form validation
    let participantForm = document.getElementById('participant-form');
    if (participantForm) {
        participantForm.addEventListener('submit', function(event) {
            let name = document.getElementById('name').value;
            let phone = document.getElementById('phone').value;
            let email = document.getElementById('email').value;
            let bid = document.getElementById('bid').value;
            
            if (!name || !phone || !email || !bid) {
                alert('All fields are required!');
                event.preventDefault(); // Prevent form submission
            }
        });
    }

    let batchForm = document.getElementById('batch-form');
    if (batchForm) {
        batchForm.addEventListener('submit', function(event) {
            let batchName = document.getElementById('batchName').value;
            let instructor = document.getElementById('instructor').value;
            
            if (!batchName || !instructor) {
                alert('All fields are required!');
                event.preventDefault(); // Prevent form submission
            }
        });
    }

    // Example: AJAX request to load data dynamically (e.g., fetching participant data)
    let loadParticipantsButton = document.getElementById('load-participants');
    if (loadParticipantsButton) {
        loadParticipantsButton.addEventListener('click', function() {
            fetch('/api/participants')
                .then(response => response.json())
                .then(data => {
                    let participantsList = document.getElementById('participants-list');
                    participantsList.innerHTML = '';
                    data.forEach(participant => {
                        let li = document.createElement('li');
                        li.textContent = `${participant.name} - ${participant.email}`;
                        participantsList.appendChild(li);
                    });
                })
                .catch(error => console.error('Error fetching participants:', error));
        });
    }
});
