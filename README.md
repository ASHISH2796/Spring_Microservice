Service & Ports

Limit service : 8080
config server : 8888
currency-exchange-service : 8001 8002 ..
currency-conversion-service :8100 8101 ..
naming server : 8761
api gateway : 8765


URL

http://localhost:8080/limits
http://localhost:8888/limits-service/default

http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
http://localhost:8000/currency-conversion/feign/from/USD/to/INR/quantity/10

swagger UI 
http://localhost:{port}/swagger-ui/index.html

API Gateway

http://localhost:8765/
Lower Case

- http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion-service/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-service/currency-conversion/feign/from/USD/to/INR/quantity/10




Custom Routes

- http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

