# Spring boot RMQ Sample Code

## Example test:

POST: /v1/rmpposttest:
```
{
	"id": 100,
	"message":"test string 1"
}
```

## Check for local rmq:
```
#Exchangename
user.exchange=rmqspringbootexchange
#Routingkeys
user.routingkey=rmqspringbootkey
```
