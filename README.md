# Caleta's application

## Overview

This Java application with Spring Boot and MariaDB implements a digital wallet system with endpoints for transaction rollback, balance retrieval, placing bets, and winning prizes.

## Installation

1. **Install dependencies:**

    

2. **Set up the environment variables:**

    

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
