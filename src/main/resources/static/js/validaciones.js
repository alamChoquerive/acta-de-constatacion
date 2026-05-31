/*
 * Validaciones del lado del cliente.
 * Equivalen a las restricciones que ponías con JOptionPane en los controllers Swing,
 * pero ahora ocurren en el navegador antes de enviar el formulario.
 */

document.addEventListener('DOMContentLoaded', function () {

    const form = document.getElementById('formCrearActa');
    if (!form) return;

    form.addEventListener('submit', function (e) {
        let valido = true;

        // Validar todos los <select> requeridos
        form.querySelectorAll('select[required]').forEach(function (sel) {
            const campo = sel.closest('.campo');
            if (!sel.value) {
                campo.classList.add('con-error');
                valido = false;
            } else {
                campo.classList.remove('con-error');
            }
        });

        // Validar campos de texto/fecha requeridos
        form.querySelectorAll('input[required]').forEach(function (inp) {
            const campo = inp.closest('.campo');
            if (!inp.value.trim()) {
                campo.classList.add('con-error');
                valido = false;
            } else {
                campo.classList.remove('con-error');
            }
        });

        if (!valido) {
            e.preventDefault(); // Detiene el envío si hay errores
        }
    });

    // Limpiar error en tiempo real al cambiar un campo
    form.querySelectorAll('input, select, textarea').forEach(function (el) {
        el.addEventListener('change', function () {
            const campo = el.closest('.campo');
            if (campo && el.value) campo.classList.remove('con-error');
        });
    });
});