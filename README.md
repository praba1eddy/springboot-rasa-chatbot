# ChatGPT-like Application Using Spring Boot, REST, and Rasa (Open Source Chatbot)

## 📝 Assignment Task
Build a ChatGPT-like application using:
- **Spring Boot** for backend REST APIs
- **Rasa** as the open-source chatbot engine
- **Maven** for project management
- **Git** for version control (must be connected to your IDE)
- **Optional Frontend**: Simple HTML + JavaScript UI

## 📦 Tech Stack
| Layer       | Technology            |
|-------------|------------------------|
| Backend     | Spring Boot (REST API) |
| Chatbot     | Rasa (Open Source)     |
| Frontend    | HTML + JavaScript *(optional)* |
| Build Tool  | Maven                 |
| VCS         | Git                   |

---

## 🛠️ Project Structure

spring-rasa-chatbot/
├── src/
│   ├── main/
│   │   ├── java/com/chatbot/
│   │   │   ├── controller/ChatController.java
│   │   │   ├── service/RasaService.java
│   │   │   ├── SecurityConfig.java
│   │   │   └── SpringRasaChatbotApplication.java
│   │   ├── resources/
│   │   │   ├── static/index.html *(Optional Frontend)*
│   │   │   ├── application.properties
│   ├── rasa_bot.rasa_bot/ *(Rasa project)*
│   │   ├── data/nlu.yml
│   │   ├── domain.yml
│   │   ├── config.yml
│   │   ├── endpoints.yml
│   │   └── models/
├── pom.xml


---

## ▶️ Steps to Run the Application

### 1. 🚀 Start Rasa Server

cd rasa_bot.rasa_bot
rasa train
rasa run -p 8090


### 2. 🔧 Configure Spring Boot
Edit `application.properties` (if needed):
properties
server.port=8081


### 3. 🧠 Backend (Spring Boot)
Run the Spring Boot app via IDE or command line:

mvn spring-boot:run


### 4. 💬 API Endpoints
| Method | URL                      | Description                  |
|--------|--------------------------|------------------------------|
| GET    | `/chat/test`            | Check if service is up       |
| POST   | `/chat/send`            | Send message to Rasa chatbot |

**Example POST Request**:
json
POST http://localhost:8081/chat/send
{
  "message": "Hi"
}


---

 🌐 Optional Frontend (HTML)
Path: src/main/resources/static/index.html`

`html
<!DOCTYPE html>
<html>
<head>
    <title>Spring Boot Rasa Chat</title>
</head>
<body>
    <h2>Spring Boot Rasa Chat</h2>
    <input type="text" id="userMessage" placeholder="Type a message...">
    <button onclick="sendMessage()">Send</button>
    <p><strong>Bot Reply:</strong> <span id="botReply"></span></p>

  <script>
        function sendMessage() {
            const message = document.getElementById("userMessage").value;
            fetch('/chat/send', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ message })
            })
            .then(res => res.text())
            .then(data => document.getElementById("botReply").innerText = data);
        }
    </script>
</body>
</html>


---

## 🧾 Git Setup
1. Initialize repo:
```bash
git init
git remote add origin <your-repo-url>
```
2. Push Code:
```bash
git add .
git commit -m "Initial commit - Spring Boot + Rasa chatbot"
git push -u origin main
```

---

## ✅ Output Example
json
User: Hi
Bot: Hey! How are you?

User: Who are you?
Bot: I am a bot, powered by Rasa.


---

## 📌 Notes
- Make sure Rasa is trained and running before hitting Spring Boot endpoints.
- Use Postman or curl for testing APIs.
- Keep models in sync between updates.

---

## 📚 Resources
- Rasa Docs: https://rasa.com/docs/
- Spring Boot Docs: https://spring.io/projects/spring-boot
- GitHub Markdown Guide: https://guides.github.com/features/mastering-markdown/

