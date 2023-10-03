# SIN

__Software Architecture__ - komponenty/ aplikaci či částí aplikace používající design patterny s jasným důvodemd

### Hodina 2

## Monolitická aplikace

- Vhodné pro měnší aplikace

## Vícevrstevná architektůra

_BusinessObjects_ - POJOs object
_repository, DAO_ - CRUD, získává data
_service_ - logika (visitor, adaptér, state, strategy)
controller - přístupy, API k servisám (facade se používá mezi service a controller)
cache - 
FrontEnd -


## Load Balancer
                        worker -> database
Client -> Dispatcher -> worker -> database
                        worker -> database


### Spring Boot

[Spring boot inititalizer:](https://start.spring.io)

Jar a War -> Jar spíše pro serverside aplikace a War je dělán spíše pro webové aplikace. Jenom doporučené použití.
Maven\Gradle -> package managment systems



