# UMB-APP_DISDIS_202

##Distributed systems microservices project

### Microservices references  👋

## Shipping Microservice

- 👯 **Create the shipping order:** 
  > Creates a new shipping order for a shopping cart operation, however it requires the purchase order history to be 
  > created first to create the shipping order.

  > To register a new Shipping, the microservice must consume the topic "Put the topic name here" it must receive
  > the following structure in JSON
  
  ```json
  {
    "address":"Av 234 # 34c - 23",
    "sentAt":1622504291,
    "receivedAt":1623195491,
    "idOrderHistory": 21
  }
  ```
  
- 🥅 **Find a shipping orders:** 
  > Search the 10 existing shipping orders in the application by the closest date

  > To call the services that make the query use the next URL
  
  ```http request
    http://localhost:8080/api/v1/shipping/{id-order-history}
  ```
  
  > When {id-order-history} is the id of the order associated to the shipping record
  > And this request return a JSON with the next structure for the order id: 21

  ```json
  {
    "code": 1,
    "message": "Request executed correctly",
    "info": [
      {
        "id": 1,
        "address":"Av 234 # 34c - 23",
        "sentAt":1622504291,
        "receivedAt":1623195491,
        "idOrderHistory": 21
      }
    ]
  }
  ```
