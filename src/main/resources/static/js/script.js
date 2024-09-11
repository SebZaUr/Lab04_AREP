// Llama a la función `read` una vez que el DOM se haya cargado completamente
document.addEventListener("DOMContentLoaded", function() {
    setupSendMessageButton(); // Cambié `read` a `setupSendMessageButton` para más claridad
});

function setupSendMessageButton() {
    document.getElementById("sendMessage").addEventListener("click", async function(event) {
        event.preventDefault(); // Previene el comportamiento predeterminado del formulario
        const messageInput = document.getElementById('messageInput');
        const message = messageInput.value.trim(); // Obtener y limpiar el mensaje de entrada
        if (message) {
            try {
                const response = await fetch('/v1/roundrobin', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'text/plain' // Enviar el mensaje como texto plano
                    },
                    body: message // Enviar el mensaje en el cuerpo de la solicitud
                });

                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                messageInput.value = '';
                const updatedMessages = await response.json(); // Esperar y obtener la respuesta en formato JSON
                createTable(updatedMessages); // Actualizar la tabla con los mensajes recibidos
            } catch (error) {
                console.error('Error:', error); // Manejar errores
            }
        }
    });
}

function createTable(messageList) {
    let tableBody = document.getElementById("courseTable").getElementsByTagName('tbody')[0];
    tableBody.innerHTML = ''; // Limpiar la tabla antes de agregar nuevos datos

    // Verifica si `messageList` es un array y tiene elementos
    if (Array.isArray(messageList) && messageList.length > 0) {
        messageList.forEach(messageObj => {
            let row = tableBody.insertRow();
            let cell1 = row.insertCell(0);
            cell1.innerHTML = messageObj.message; // Mostrar el mensaje en la primera celda
        });
    } else {
        // Mostrar un mensaje si no hay datos
        let row = tableBody.insertRow();
        let cell1 = row.insertCell(0);
        cell1.innerHTML = 'No hay mensajes para mostrar';
    }
}
