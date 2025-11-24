document.addEventListener('DOMContentLoaded', function() {
    // Cargar información del usuario en el header
    const userName = localStorage.getItem('userName') || 'Usuario';
    const userEmail = localStorage.getItem('userEmail') || 'usuario@email.com';

    const userNameElement = document.getElementById('userName');
    const userEmailElement = document.getElementById('headerEmail');

    if (userNameElement) {
        userNameElement.textContent = userName;
    }
    if (userEmailElement) {
        userEmailElement.textContent = userEmail;
    }

    // Funcionalidad de Logout
    const btnLogout = document.getElementById('btnLogout');
    if (btnLogout) {
        btnLogout.addEventListener('click', function() {
            if (confirm('¿Estás seguro de que quieres cerrar sesión?')) {
                // Limpiar datos de sesión
                localStorage.removeItem('userName');
                localStorage.removeItem('userEmail');
                localStorage.removeItem('userGoal');

                // Redirigir a la página principal
                window.location.href = 'index.html';
            }
        });
    }
});
