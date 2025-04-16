Spring Boot Microservices Chatbot with Rasa

This project is a simple ChatGPT-like chatbot application that integrates a Spring Boot microservice with a Rasa NLU engine using REST APIs. The frontend is an optional basic HTML/JavaScript interface. All code is version-controlled using Git and connected to the IDE.

💡 Features
Chat with a Rasa-powered bot via Spring Boot REST API
Microservices architecture with Spring Boot backend
RESTful communication with Rasa
NLP powered by Rasa (open-source)
Optional frontend using simple HTML/JavaScript
Built using Maven and Git

Project Structure
spring-rasa-chatbot/
├── src/

│   ├── main/

│   │   ├── java/com/chatbot/

│   │   │   ├── controller/ChatController.java

│   │   │   ├── service/RasaService.java
│   │   │   ├── config/SecurityConfig.java
│   │   │   └── SpringRasaChatbotApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── static/index.html
│   └── rasa_bot.rasa_bot/
│       ├── data/nlu.yml
│       ├── domain.yml
│       ├── config.yml
│       ├── endpoints.yml
│       └── models/

How to Run

1️⃣ Clone the Repository & Connect Git

git clone https://github.com/your-username/spring-rasa-chatbot.git
cd spring-rasa-chatbot
git remote -v
Ensure your IDE (e.g., IntelliJ, Eclipse) is connected to Git and project is imported.
2️⃣ Run Rasa Server
cd rasa_bot.rasa_bot
rasa train
rasa run --enable-api --cors "*" -p 8090
3️⃣ Run Spring Boot Application
./mvnw spring-boot:run
Or run SpringRasaChatbotApplication.java from your IDE.
4️⃣ Access the Chat UI
Open http://localhost:8081
🧪 Test with curl
curl -X POST http://localhost:8081/chat/send \
-H "Content-Type: application/json" \
-d '{"message": "hi"}'
💬 Sample Interactions
User Message
Bot Reply
hi
Hey! How are you?
who are you
I am a bot, powered by Rasa.
how are you
I am good, how are you?

⚙️ Tech Stack
Spring Boot 3.4.4
Java 17+
Rasa 3.x
REST APIs
HTML/JavaScript (optional)
Maven
Git

🛡️ Security

To disable Spring Security login prompt, modify SecurityConfig.java:

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http.csrf().disable()
.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
return http.build();
}

📦 Build with Maven

mvn clean install
🧠 Train Rasa Model

cd rasa_bot.rasa_bot
rasa train


Happy Building Your Own ChatGPT-style Chatbot with Spring Boot & Rasa! 🤖
