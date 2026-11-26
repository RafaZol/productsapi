# Products API

REST API for creating, searching, updating, and deleting products. The project uses Java 21, Spring Boot 3.2.5, Spring Data JPA, and an in-memory H2 database.

## Requirements

- JDK 21

## Run

From the project directory:

```bash
./mvnw spring-boot:run
```

To package the application:

```bash
./mvnw clean package
```

The API is available at `http://localhost:8080`.

## Endpoints

| Method | Path | Description |
|---|---|---|
| `POST` | `/product` | Create a product; the API generates its ID |
| `GET` | `/product/{id}` | Find a product by ID |
| `GET` | `/product?name={name}` | Find products by exact name |
| `PUT` | `/product/{id}` | Create or update a product with the specified ID |
| `DELETE` | `/product/{id}` | Delete a product by ID |

Example request body:

```json
{
  "name": "Keyboard",
  "description": "Mechanical keyboard",
  "price": 79.99
}
```

Create a product with `curl`:

```bash
curl -X POST http://localhost:8080/product \
  -H "Content-Type: application/json" \
  -d '{"name":"Keyboard","description":"Mechanical keyboard","price":79.99}'
```

## H2 database

The application uses an in-memory database, so its data is not retained when the application stops. The H2 console is available at `http://localhost:8080/h2-console`.

Use the JDBC URL `jdbc:h2:mem:productsbd`, username `sa`, and password `password` to connect.
