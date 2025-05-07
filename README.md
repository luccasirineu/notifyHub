# 📬 NotifyHub

**NotifyHub** é uma plataforma de **notificações assíncronas** desenvolvida com foco em escalabilidade, mensageria e arquitetura de microservices. A aplicação permite o envio de **e-mails e SMS** com gerenciamento centralizado, utilizando **RabbitMQ** como sistema de filas e **Java com Spring Boot** para os serviços.

---

## ⚙️ Tecnologias utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **RabbitMQ**
- **MySQL**
- **Docker + Docker Compose**
- **API Vonage (SMS)**
- **SMTP (Email)**
- **Arquitetura de Microservices**

---

## 🧩 Arquitetura

A arquitetura do NotifyHub é composta por tres microserviços principais:

```plaintext
                          +--------------------+
                          |      Frontend      |
                          +---------+----------+
                                    |
                                    v
                    +---------------+--------------+
                    |     Notification API         |
                    | (Orquestrador de notificações)|
                    +-------+------------+---------+
                            |            |
                   +--------+--+     +---+---------+
                   | Email API |     |   SMS API   |
                   +-----------+     +-------------+
                           \               /
                            \             /
                        +---------------------+
                        |      RabbitMQ       |
                        +---------------------+
                                |
                          +-----v-----+
                          |   MySQL   |
                          +-----------+
