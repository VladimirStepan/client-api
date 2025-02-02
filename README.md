# Client API

Этот проект — REST API, построенное с использованием Spring Boot для управления клиентами и их контактной информацией.  
Поддерживаются операции для управления клиентами и их контактами (например, номера телефонов и адреса электронной почты).

## Возможности

1. Добавление нового клиента.
2. Добавление контакта (телефон/электронная почта) для клиента.
3. Получение списка всех клиентов.
4. Получение информации о конкретном клиенте по ID.
5. Получение всех контактов конкретного клиента.
6. Получение контактов заданного типа (например, PHONE/EMAIL) для клиента.

---

## Используемые технологии

- **Spring Boot**: Основной фреймворк.
- **Spring Data JPA**: Для работы с базой данных.
- **PostgreSql Database**: База данных.
- **MapStruct**: Для преобразования объектов.
- **Lombok**: Уменьшение шаблонного кода.
- **Swagger/OpenAPI**: Документация API.
- **JUnit**: Для модульного тестирования.
- **Docker**: Поддержка контейнеризации.

---

## Начало работы

### Предварительные требования

- **Java 17** или новее.
- **Maven** для управления зависимостями.
- **Docker** и **Docker Compose** (если вы хотите использовать контейнеры).

---

### Запуск локально (без докера)

1. Клонируйте репозиторий
2. mvn clean install
3. mvn spring-boot:run
4. Откройте документацию Swagger: Перейдите по адресу http://localhost:8080/swagger-ui.html.

### Запуск локально (с докером)

1. Клонируйте репозиторий
2. запуск docker-compose - docker compose up -d (в корне проекта)
4. Откройте документацию Swagger: Перейдите по адресу http://localhost:8080/swagger-ui.html.
