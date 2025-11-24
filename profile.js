(function () {
    'use strict';

    const $ = sel => document.querySelector(sel);
    const $$ = sel => document.querySelectorAll(sel);

    function toast(msg, time = 4000) {
        const t = document.createElement('div');
        t.className = 'toast';
        t.textContent = msg;
        $('#toasts').appendChild(t);
        setTimeout(() => t.remove(), time);
    }

    // Carga inicial
    document.addEventListener('DOMContentLoaded', () => {
        const savedName = localStorage.getItem('userName') || 'María González';
        const savedEmail = localStorage.getItem('userEmail') || 'maria.gonzalez@email.com';

        $('#displayName').textContent = savedName;
        $('#displayEmail').textContent = savedEmail;

        const initials = savedName.split(' ').map(n => n[0]).join('').slice(0,2).toUpperCase();
        $('#userAvatar').textContent = initials || 'US';

        loadFormData();
        setupTabs();
        setupDeviceButtons();
    });

    function loadFormData() {
        const keys = ['FirstName','LastName','BirthDate','Gender','Height','Weight','Phone','Location'];
        keys.forEach(k => {
            const value = localStorage.getItem('profile' + k);
            if (value && $('#' + k.toLowerCase())) $('#' + k.toLowerCase()).value = value;
        });
        const email = localStorage.getItem('userEmail');
        if (email) $('#emailInput').value = email;

        // Cargar datos de otras pestañas
        const goals = ['weightGoal', 'stepsGoal', 'waterGoal', 'sleepGoal', 'caloriesGoal'];
        goals.forEach(id => {
            const value = localStorage.getItem(id);
            if (value && $('#' + id)) $('#' + id).value = value;
        });

        const notifications = ['notifActivity', 'notifWater', 'notifSleep', 'notifGoals', 'notifNews'];
        notifications.forEach(id => {
            const value = localStorage.getItem(id);
            if (value && $('#' + id)) $('#' + id).checked = value === 'true';
        });

        const privacy = ['privacyProfile', 'privacyActivity', 'privacyStats'];
        privacy.forEach(id => {
            const value = localStorage.getItem(id);
            if (value && $('#' + id)) $('#' + id).checked = value === 'true';
        });

        const dataSharing = localStorage.getItem('dataSharing');
        if (dataSharing && $('#dataSharing')) $('#dataSharing').value = dataSharing;

        const healthNotes = localStorage.getItem('healthNotes');
        if (healthNotes && $('#healthNotes')) $('#healthNotes').value = healthNotes;
    }

    function setupTabs() {
        $$('.tab-btn').forEach(btn => {
            btn.onclick = () => {
                $$('.tab-btn').forEach(b => b.classList.remove('active'));
                $$('.tab-content').forEach(c => c.classList.remove('active'));
                btn.classList.add('active');
                const tab = document.getElementById(btn.dataset.tab + '-tab');
                if (tab) tab.classList.add('active');
            };
        });
    }

    function setupDeviceButtons() {
        $$('.btn-connect').forEach(btn => {
            btn.onclick = function() {
                const deviceItem = this.closest('.device-item');
                const status = deviceItem.querySelector('.status-connected, .status-disconnected, .status-syncing');

                if (status.classList.contains('status-connected')) {
                    status.textContent = 'Desconectado';
                    status.classList.remove('status-connected');
                    status.classList.add('status-disconnected');
                    this.textContent = 'Conectar';
                    toast('Dispositivo desconectado');
                } else if (status.classList.contains('status-disconnected')) {
                    status.textContent = 'Sincronizando';
                    status.classList.remove('status-disconnected');
                    status.classList.add('status-syncing');
                    this.textContent = 'Espere...';
                    this.disabled = true;

                    // Simular proceso de conexión
                    setTimeout(() => {
                        status.textContent = 'Conectado';
                        status.classList.remove('status-syncing');
                        status.classList.add('status-connected');
                        this.textContent = 'Desconectar';
                        this.disabled = false;
                        toast('Dispositivo conectado correctamente');
                    }, 2000);
                }
            };
        });
    }

    // Guardar perfil
    $('#profileForm').onsubmit = e => {
        e.preventDefault();

        const first = $('#firstName').value.trim();
        const last = $('#lastName').value.trim();
        const email = $('#emailInput').value.trim();
        const fullName = `${first} ${last}`;

        localStorage.setItem('userName', fullName);
        localStorage.setItem('userEmail', email);
        localStorage.setItem('profileFirstName', first);
        localStorage.setItem('profileLastName', last);
        localStorage.setItem('profileBirthDate', $('#birthDate').value);
        localStorage.setItem('profileGender', $('#gender').value);
        localStorage.setItem('profileHeight', $('#height').value);
        localStorage.setItem('profileWeight', $('#weight').value);
        localStorage.setItem('profilePhone', $('#phone').value);
        localStorage.setItem('profileLocation', $('#location').value);

        // Actualizar UI
        $('#userName').textContent = fullName;
        $('#headerEmail').textContent = email;
        $('#displayName').textContent = fullName;
        $('#displayEmail').textContent = email;
        $('#userAvatar').textContent = (first[0] + last[0]).toUpperCase();

        toast('Perfil guardado correctamente');
    };

    // Guardar notas de salud
    $('#saveHealthNotes').onclick = () => {
        localStorage.setItem('healthNotes', $('#healthNotes').value);
        toast('Notas de salud guardadas');
    };

    // Guardar metas
    $('#saveGoals').onclick = () => {
        const goals = ['weightGoal', 'stepsGoal', 'waterGoal', 'sleepGoal', 'caloriesGoal'];
        goals.forEach(id => {
            localStorage.setItem(id, $('#' + id).value);
        });
        toast('Metas actualizadas correctamente');
    };

    // Guardar notificaciones
    $('#saveNotifications').onclick = () => {
        const notifications = ['notifActivity', 'notifWater', 'notifSleep', 'notifGoals', 'notifNews'];
        notifications.forEach(id => {
            localStorage.setItem(id, $('#' + id).checked);
        });
        toast('Preferencias de notificaciones guardadas');
    };

    // Guardar privacidad
    $('#savePrivacy').onclick = () => {
        const privacy = ['privacyProfile', 'privacyActivity', 'privacyStats'];
        privacy.forEach(id => {
            localStorage.setItem(id, $('#' + id).checked);
        });
        localStorage.setItem('dataSharing', $('#dataSharing').value);
        toast('Configuración de privacidad guardada');
    };

    // Sincronizar
    $('#btnSync').onclick = function() {
        const txt = this.innerHTML;
        this.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Sincronizando...';
        this.disabled = true;
        setTimeout(() => {
            this.innerHTML = txt;
            this.disabled = false;
            toast('Sincronización completada');
        }, 1800);
    };

    // Exportar datos
    $('#exportData').onclick = () => {
        if (confirm('¿Estás seguro de que quieres exportar todos tus datos?')) {
            toast('Tus datos se están preparando para la exportación. Recibirás un email cuando estén listos.');
        }
    };

    // Limpiar datos
    $('#clearData').onclick = () => {
        if (confirm('¿Estás seguro de que quieres eliminar todos los datos locales? Esta acción no afectará tu cuenta en la nube.')) {
            // Eliminar solo datos locales específicos
            const keysToRemove = [];
            for (let i = 0; i < localStorage.length; i++) {
                const key = localStorage.key(i);
                if (key.startsWith('profile') || key.includes('Goal') || key.includes('notif') || key.includes('privacy')) {
                    keysToRemove.push(key);
                }
            }

            keysToRemove.forEach(key => localStorage.removeItem(key));
            toast('Datos locales eliminados correctamente');
        }
    };

    // Eliminar cuenta
    $('#deleteAccount').onclick = () => {
        if (confirm('¿ESTÁS ABSOLUTAMENTE SEGURO? Esta acción eliminará permanentemente tu cuenta y todos tus datos. Esta acción no se puede deshacer.')) {
            if (confirm('Última confirmación: ¿Realmente quieres eliminar tu cuenta de Health Track?')) {
                localStorage.clear();
                toast('Tu cuenta ha sido eliminada. Serás redirigido a la página principal.');
                setTimeout(() => location.href = 'index.html', 2000);
            }
        }
    };

    // Logout
    $('#btnLogout').onclick = () => {
        if (confirm('¿Cerrar sesión?')) {
            toast('Sesión cerrada');
            setTimeout(() => location.href = 'index.html', 1000);
        }
    };

})();
