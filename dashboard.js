document.addEventListener('DOMContentLoaded', function() {
    const userGoal = localStorage.getItem('userGoal') || 'No especificado';

    // Traducir objetivo a texto legible
    const goalTranslations = {
        'weight-loss': 'Pérdida de peso',
        'fitness': 'Mejorar condición física',
        'health-monitoring': 'Monitoreo de salud',
        'nutrition': 'Mejorar alimentación',
        'stress-management': 'Manejo del estrés',
        'other': 'Otro objetivo personalizado'
    };

    const displayGoal = goalTranslations[userGoal] || userGoal;
    const userGoalElement = document.getElementById('userGoal');
    if (userGoalElement) {
        userGoalElement.textContent = displayGoal;
    }
});
