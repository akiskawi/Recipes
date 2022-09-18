var chat = document.getElementById('chat');
chat.scrollTop = chat.scrollHeight - chat.clientHeight;

function toggleChat() {
    var x = document.getElementById("chat-container");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}