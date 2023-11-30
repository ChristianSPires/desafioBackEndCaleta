# Caleta's application

## Overview

This Java application with Spring Boot and MariaDB implements a digital wallet system with endpoints for transaction rollback, balance retrieval, placing bets, and winning prizes.

## Installation

1. **Setup application.properties:**

    Create a `application.properties` file on the project with the following content:

    ```plaintext
    # Database Configuration
    spring.datasource.url=jdbc:mariadb://localhost:3306/digital_wallet
    spring.datasource.username=your_database_username
    spring.datasource.password=your_database_password
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    
    # Hibernate Configuration
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.hibernate.ddl-auto=create
    
    # Server Configuration
    server.error.include-message=always
    ```

1. **Set up the MariaDB database and run the application:**
    
    - Ensure MariaDB is installed and running.
    - Create a database named `digital_wallet`.
    - Run the application.
    - Populate the tables:

    ```plaintext
    INSERT INTO player_entity (balance) VALUES (1000.00);
    ```

The application will be running on [http://localhost:8080/player](http://localhost:8080/player).

## Endpoints

### 1. Rollback Transaction

- **Endpoint:** `POST /rollback`
- **Description:** Cancel a previous bet transaction and return the amount to the digital wallet.
- **Request Example:**

    ```json
    {
      "player": 1,
      "txn": 3,
      "value": 10
    }
    ```

- **Response Example:**

    ```json
    {
      "code": "OK",
      "balance": 1995
    }
    ```

### 2. Get Wallet Balance

- **Endpoint:** `GET /balance/:player`
- **Description:** Retrieve the balance of the digital wallet for a specific player.
- **Request Example:**

    ```http
    GET /balance/1
    ```

- **Response Example:**

    ```json
    {
      "player": 1,
      "balance": 1000
    }
    ```

### 3. Place Bet

- **Endpoint:** `POST /bet`
- **Description:** Place a bet using the digital wallet of a player.
- **Request Example:**

    ```json
    {
      "player": 1,
      "value": 5
    }
    ```

- **Response Example:**

    ```json
    {
      "player": 1,
      "balance": 995,
      "txn": 1
    }
    ```

### 4. Win Prize

- **Endpoint:** `POST /win`
- **Description:** Win a prize using the digital wallet of a player.
- **Request Example:**

    ```json
    {
      "player": 1,
      "value": 1000
    }
    ```

- **Response Example:**

    ```json
    {
      "player": 1,
      "balance": 1995,
      "txn": 2
    }
    ```

## License

This project is licensed under the [MIT License](LICENSE).
